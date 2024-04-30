SUMMARY = "Custom package group for vendor layer"

LICENSE = "MIT"

PACKAGE_ARCH = "${VENDOR_LAYER_EXTENSION}"

inherit packagegroup
inherit versioned-packagegroup-install-support

DEPENDS = " android-raspberrypi make-mod-scripts"

PV = "1.0.0"
PR = "r0"

RDEPENDS_${PN} = "\
        cairo \
        gstreamer1.0 \
        gstreamer1.0-libav \
        gstreamer1.0-plugins-base \
        gstreamer1.0-plugins-good \
        gstreamer1.0-plugins-bad \
	westeros-simplebuffer \
        westeros-simpleshell \
        westeros-soc-drm \
        westeros \
        "

# Include MACHINE specific HAL packagegroup.

RDEPENDS_${PN}_raspberrypi4 += " \
    packagegroup-hal-raspberrypi4 \
    "
