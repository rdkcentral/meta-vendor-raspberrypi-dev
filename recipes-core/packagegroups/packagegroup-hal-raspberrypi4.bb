SUMMARY = "RDKV HAL packagegroup of RaspberryPi-4"

LICENSE = "MIT"

PACKAGE_ARCH = "${VENDOR_LAYER_EXTENSION}"

inherit packagegroup

PV = "1.0.0"
PR = "r0"

RDEPENDS_${PN} = " \
    devicesettings-hal-raspberrypi4 \
    hdmicec-hal-raspberrypi4 \
    iarmmgrs-hal-raspberrypi4 \
    pwrmgr-hal-raspberrypi4 \
    deepsleepmgr-hal-raspberrypi4 \
    mfrlibs-hal-raspberrypi4 \
    "

