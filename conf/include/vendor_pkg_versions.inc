# This layer shall be common for all RPi variants.

#Linux kernel components

PV_pn-linux-libc-headers = "5.10.52"
PR_pn-linux-libc-headers = "r0"
PACKAGE_ARCH_pn-linux-libc-headers = "${VENDOR_LAYER_EXTENSION}"

PV_pn-android-raspberrypi = "5.10.82"
PR_pn-android-raspberrypi = "r0"
PACKAGE_ARCH_pn-android-raspberrypi = "${VENDOR_LAYER_EXTENSION}"

PV_pn-cairo = "1.14.6"
PR_pn-cairo = "r1"
PACKAGE_ARCH_pn-cairo = "${VENDOR_LAYER_EXTENSION}"

#gstreamer components

GST_VERSION = "1.18.5"
GST_REVISION = "r0"

PV_pn-gstreamer1.0 = "${GST_VERSION}"
PR_pn-gstreamer1.0 = "${GST_REVISION}"
PACKAGE_ARCH_pn-gstreamer1.0 = "${VENDOR_LAYER_EXTENSION}"

PV_pn-gstreamer1.0-plugins-base = "${GST_VERSION}"
PR_pn-gstreamer1.0-plugins-base = "${GST_REVISION}"
PACKAGE_ARCH_pn-gstreamer1.0-plugins-base = "${VENDOR_LAYER_EXTENSION}"

PV_pn-gstreamer1.0-libav = "${GST_VERSION}"
PR_pn-gstreamer1.0-libav = "${GST_REVISION}"
PACKAGE_ARCH_pn-gstreamer1.0-libav = "${VENDOR_LAYER_EXTENSION}"

PV_pn-gstreamer1.0-plugins-good = "${GST_VERSION}"
PR_pn-gstreamer1.0-plugins-good = "${GST_REVISION}"
PACKAGE_ARCH_pn-gstreamer1.0-plugins-good = "${VENDOR_LAYER_EXTENSION}"

PV_pn-gstreamer1.0-plugins-bad = "${GST_VERSION}"
PR_pn-gstreamer1.0-plugins-bad = "${GST_REVISION}"
PACKAGE_ARCH_pn-gstreamer1.0-plugins-bad = "${VENDOR_LAYER_EXTENSION}"

#westeros components
WESTEROS_VERSION = "1.0.0"
WESTEROS_REVISION = "r0"

PV_pn-westeros-simplebuffer = "${WESTEROS_VERSION}"
PR_pn-westeros-simplebuffer = "${WESTEROS_REVISION}"
PACKAGE_ARCH_pn-westeros-simplebuffer = "${VENDOR_LAYER_EXTENSION}"

PV_pn-westeros-simpleshell = "${WESTEROS_VERSION}"
PR_pn-westeros-simpleshell = "${WESTEROS_REVISION}"
PACKAGE_ARCH_pn-westeros-simpleshell = "${VENDOR_LAYER_EXTENSION}"

PV_pn-westeros-soc-drm = "${WESTEROS_VERSION}"
PR_pn-westeros-soc-drm = "${WESTEROS_REVISION}"
PACKAGE_ARCH_pn-westeros-soc-drm = "${VENDOR_LAYER_EXTENSION}"

PV_pn-westeros = "${WESTEROS_VERSION}"
PR_pn-westeros = "${WESTEROS_REVISION}"
PACKAGE_ARCH_pn-westeros = "${VENDOR_LAYER_EXTENSION}"

# RDKV HAL component versions

# RDKV HAL component versions of raspberrypi4
SRCREV_pn-devicesettings-hal-raspberrypi4 = "1.0.0"
PV_pn-devicesettings-hal-raspberrypi4 = "1.0.0"
PR_pn-devicesettings-hal-raspberrypi4 = "r0"
PACKAGE_ARCH_pn-devicesettings-hal-raspberrypi4 = "${VENDOR_LAYER_EXTENSION}"
