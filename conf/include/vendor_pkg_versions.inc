# This layer shall be common for all RPi variants.

#Linux kernel components

PV_pn-linux-libc-headers = "5.10.52"
PR_pn-linux-libc-headers = "r0"
PACKAGE_ARCH_pn-linux-libc-headers = "${VENDOR_LAYER_EXTENSION}"

PV_pn-android-raspberrypi = "5.10.82"
PR_pn-android-raspberrypi = "r0"
PACKAGE_ARCH_pn-android-raspberrypi = "${VENDOR_LAYER_EXTENSION}"

#PREFERRED_VERSION_linux-libc-headers = "5.10.%"

PV_pn-cairo = "1.14.6"
PR_pn-cairo = "r1"
PACKAGE_ARCH_pn-cairo = "${VENDOR_LAYER_EXTENSION}"

#gstreamer components

GST_VERSION = "1.18.5"
GST_REVISION = "r0"

PV_pn-gstreamer1.0 = "${GST_VERSION}"
PR_pn-gstreamer1.0 = "${GST_REVISION}"
PACKAGE_ARCH_pn-gstreamer1.0 = "${VENDOR_LAYER_EXTENSION}"

# RDKV HAL component versions

# RDKV HAL component versions of raspberrypi4
PV_pn-devicesettings-hal-raspberrypi4 = "1.0.0"
PR_pn-devicesettings-hal-raspberrypi4 = "r0"
PACKAGE_ARCH_pn-devicesettings-hal-raspberrypi4 = "${VENDOR_LAYER_EXTENSION}"
