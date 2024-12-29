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
    udhcpc -i "$INTERFACE"
    if [ $? -ne 0 ]; then
        echo "Failed to acquire IP address using udhcpc on $INTERFACE."
        exit 1
    fi

    IP_ADDRESS_V4=$(ip -4 addr show "$INTERFACE" | awk '/inet / {print $2}' | cut -d/ -f1)
    IP_ADDRESS_V6=$(ip -6 addr show "$INTERFACE" | awk '/inet6 / {print $2}' | cut -d/ -f1)

    if [ -z "$IP_ADDRESS_V4" ] && [ -z "$IP_ADDRESS_V6" ]; then
        echo "Failed to acquire IP address on $INTERFACE."
        exit 1
    fi

    echo "Successfully acquired IP addresses on $INTERFACE:"
    [ -n "$IP_ADDRESS_V4" ] && echo "IPv4: $IP_ADDRESS_V4"
    [ -n "$IP_ADDRESS_V6" ] && echo "IPv6: $IP_ADDRESS_V6"
}

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
