#!/bin/bash

INTERFACE="eth0"

interface_exists() {
    [ -d /sys/class/net/$INTERFACE ]
}

is_operstate_up() {
    [ "$(cat /sys/class/net/$INTERFACE/operstate)" = "up" ]
}

is_carrier_detected() {
    [ "$(cat /sys/class/net/$INTERFACE/carrier)" = "1" ]
}

bring_interface_up() {
    ip link set "$INTERFACE" up
}

wait_for_carrier() {
    while ! is_carrier_detected; do
        echo "Waiting for carrier on $INTERFACE..."
        sleep 2
    done
    echo "Carrier detected on $INTERFACE."
}

run_udhcpc_and_verify() {
    udhcpc -i "$INTERFACE" -t 10 -T 3 -A 3 -n -p /tmp/udhcpc."$INTERFACE".pid
    if [ $? -eq 0 ]; then
        IP_ADDRESS_V4=$(ip -4 addr show "$INTERFACE" | awk '/inet / {print $2}' | cut -d/ -f1)
        IP_ADDRESS_V6=$(ip -6 addr show "$INTERFACE" | awk '/inet6 / {print $2}' | cut -d/ -f1)

        if [ -n "$IP_ADDRESS_V4" ] || [ -n "$IP_ADDRESS_V6" ]; then
            echo "Successfully acquired IP addresses on $INTERFACE:"
            [ -n "$IP_ADDRESS_V4" ] && echo "IPv4: $IP_ADDRESS_V4"
            [ -n "$IP_ADDRESS_V6" ] && echo "IPv6: $IP_ADDRESS_V6"
            return 0
        fi
    fi

    echo "Failed to acquire IP address on $INTERFACE after $timeout seconds."
    return 1
}

# Ensure the script is run as root
if [ "$EUID" -ne 0 ]; then
    echo "Please run as root"
    exit 1
fi

# Main script execution
if ! interface_exists; then
    echo "Interface $INTERFACE does not exist."
    exit 1
fi

if ! is_operstate_up; then
    echo "$INTERFACE is down. Bringing it up..."
    bring_interface_up
fi

wait_for_carrier
run_udhcpc_and_verify
# monitor the carrier and exit if its lost cleaning up the udhcpc process as well as the interface IP
while is_carrier_detected; do
    sleep 2
done
ip addr flush dev "$INTERFACE"
if [ -f /tmp/udhcpc."$INTERFACE".pid ]; then
    kill -9 $(cat /tmp/udhcpc."$INTERFACE".pid)
fi
exit 0
