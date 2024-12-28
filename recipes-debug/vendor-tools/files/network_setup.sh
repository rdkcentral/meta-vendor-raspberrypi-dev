#!/bin/bash

# Define the interface (eth0 or eth1)
INTERFACE="eth0"

# Function to check if the interface is up
is_interface_up() {
    ip link show "$INTERFACE" | grep -q "state UP"
}

# Function to bring the interface up
bring_interface_up() {
    ip link set "$INTERFACE" up
}

# Function to wait until the interface is ready
wait_for_interface() {
    while ! is_interface_up; do
        echo "Waiting for $INTERFACE to be up..."
        sleep 1
    done
    echo "$INTERFACE is up."
}

# Function to run udhcpc and verify IP connectivity
run_udhcpc_and_verify() {
    udhcpc -i "$INTERFACE"
    if [ $? -ne 0 ]; then
        echo "Failed to acquire IP address using udhcpc on $INTERFACE."
        exit 1
    fi

    # Verify IP connectivity
    IP_ADDRESS=$(ip -4 addr show "$INTERFACE" | grep -oP '(?<=inet\s)\d+(\.\d+){3}')
    if [ -z "$IP_ADDRESS" ]; then
        echo "Failed to acquire IP address on $INTERFACE."
        exit 1
    fi

    echo "Successfully acquired IP address $IP_ADDRESS on $INTERFACE."
}

# Main script execution
if ! is_interface_up; then
    echo "$INTERFACE is down. Bringing it up..."
    bring_interface_up
    wait_for_interface
else
    echo "$INTERFACE is already up."
fi

run_udhcpc_and_verify
