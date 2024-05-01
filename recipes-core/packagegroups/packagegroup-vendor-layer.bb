SUMMARY = "Custom package group for vendor layer"

LICENSE = "MIT"

PACKAGE_ARCH = "${VENDOR_LAYER_EXTENSION}"

inherit packagegroup
inherit versioned-packagegroup-install-support

DEPENDS = " android-raspberrypi make-mod-scripts"

PV = "1.0.0"
PR = "r0"

RDEPENDS_${PN} = "\
        westeros-soc-drm \
        "

# Include MACHINE specific HAL packagegroup.
RDEPENDS_${PN}:append:raspberrypi4 = " \
        packagegroup-hal-raspberrypi4 \
        "

# These packages shall be moved to OSS layer in future.
RDEPENDS_${PN}:append:rdkv-oss = "\
        cairo \
        gstreamer1.0 \
        westeros-simplebuffer \
        westeros-simpleshell \
        westeros \
        gstreamer1.0-plugins-base \
        "
