SUMMARY = "RDKV HAL packagegroup of RaspberryPi-4"

LICENSE = "MIT"

PACKAGE_ARCH = "${VENDOR_LAYER_EXTENSION}"

inherit packagegroup
inherit versioned-packagegroup-install-support

PV = "1.0.0"
PR = "r0"

RDEPENDS_${PN} = " \
    devicesettings-hal-raspberrypi4 \
    "
