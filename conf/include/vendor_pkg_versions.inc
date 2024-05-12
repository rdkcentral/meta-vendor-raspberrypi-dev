# This layer shall be common for all RPi variants.

#Linux kernel components

PV_pn-linux-libc-headers = "5.10.52"
PR_pn-linux-libc-headers = "r0"
PACKAGE_ARCH_pn-linux-libc-headers = "${VENDOR_LAYER_EXTENSION}"
PREFERRED_VERSION_linux-libc-headers = "5.10.%"

PV_pn-android-raspberrypi = "5.10.82"
PR_pn-android-raspberrypi = "r0"
PACKAGE_ARCH_pn-android-raspberrypi = "${VENDOR_LAYER_EXTENSION}"
PREFERRED_VERSION_android-raspberrypi = "5.10.%"

PV_pn-packagegroup-kernel-modules-raspberrypi4 = "5.10.82"
PR_pn-packagegroup-kernel-modules-raspberrypi4 = "r0"
PACKAGE_ARCH_pn-packagegroup-kernel-modules-raspberrypi4 = "${VENDOR_LAYER_EXTENSION}"

PV_pn-linux-firmware-rpidistro = "1.0.0"
PR_pn-linux-firmware-rpidistro = "r0"
PACKAGE_ARCH_pn-linux-firmware-rpidistro = "${VENDOR_LAYER_EXTENSION}"

PV_pn-bluez-firmware-rpidistro = "1.0.0"
PR_pn-bluez-firmware-rpidistro = "r0"
PACKAGE_ARCH_pn-bluez-firmware-rpidistro = "${VENDOR_LAYER_EXTENSION}"

#OSS Components

PV_pn-libepoxy = "1.5.4"
PR_pn-libepoxy = "r0"
PACKAGE_ARCH_pn-libepoxy = "${VENDOR_LAYER_EXTENSION}"

PV_pn-make-mod-scripts = "1.0"
PR_pn-make-mod-scripts = "r0"
PACKAGE_ARCH_pn-make-mod-scripts = "${VENDOR_LAYER_EXTENSION}"

PV_pn-cairo = "1.14.6"
PR_pn-cairo = "r1"
PACKAGE_ARCH_pn-cairo = "${VENDOR_LAYER_EXTENSION}"

#Gstreamer components

GST_VERSION = "1.18.5"
GST_REVISION = "r0"

PV_pn-gstreamer1.0 = "${GST_VERSION}"
PR_pn-gstreamer1.0 = "${GST_REVISION}"
PACKAGE_ARCH_pn-gstreamer1.0 = "${VENDOR_LAYER_EXTENSION}"
PREFERRED_VERSION_gstreamer1.0 ?= "${GST_VERSION}"

PV_pn-gstreamer1.0-plugins-base = "${GST_VERSION}"
PR_pn-gstreamer1.0-plugins-base = "${GST_REVISION}"
PACKAGE_ARCH_pn-gstreamer1.0-plugins-base = "${VENDOR_LAYER_EXTENSION}"
PREFERRED_VERSION_gstreamer1.0-plugins-base ?= "${GST_VERSION}"

PV_pn-gstreamer1.0-libav = "${GST_VERSION}"
PR_pn-gstreamer1.0-libav = "${GST_REVISION}"
PACKAGE_ARCH_pn-gstreamer1.0-libav = "${VENDOR_LAYER_EXTENSION}"
PREFERRED_VERSION_gstreamer1.0-libav ?= "${GST_VERSION}"

PV_pn-gstreamer1.0-plugins-good = "${GST_VERSION}"
PR_pn-gstreamer1.0-plugins-good = "${GST_REVISION}"
PACKAGE_ARCH_pn-gstreamer1.0-plugins-good = "${VENDOR_LAYER_EXTENSION}"
PREFERRED_VERSION_gstreamer1.0-plugins-good ?= "${GST_VERSION}"

PV_pn-gstreamer1.0-plugins-bad = "${GST_VERSION}"
PR_pn-gstreamer1.0-plugins-bad = "${GST_REVISION}"
PACKAGE_ARCH_pn-gstreamer1.0-plugins-bad = "${VENDOR_LAYER_EXTENSION}"
PREFERRED_VERSION_gstreamer1.0-plugins-bad ?= "${GST_VERSION}"

# Westeros components
WESTEROS_VERSION = "1.0.0"
WESTEROS_REVISION = "r0"
# Tip of westeros master as of Mar 7, 2024
WESTEROS_SRCREV = "04c096cb3df0bc0797f5b6bc568e1d11b62dcb5b"

PV_pn-westeros-simplebuffer = "${WESTEROS_VERSION}"
PR_pn-westeros-simplebuffer = "${WESTEROS_REVISION}"
PACKAGE_ARCH_pn-westeros-simplebuffer = "${VENDOR_LAYER_EXTENSION}"
SRCREV_pn-westeros-simplebuffer = "${WESTEROS_SRCREV}"

PV_pn-westeros-simpleshell = "${WESTEROS_VERSION}"
PR_pn-westeros-simpleshell = "${WESTEROS_REVISION}"
PACKAGE_ARCH_pn-westeros-simpleshell = "${VENDOR_LAYER_EXTENSION}"
SRCREV_pn-westeros-simpleshell = "${WESTEROS_SRCREV}"

PV_pn-westeros-soc-drm = "${WESTEROS_VERSION}"
PR_pn-westeros-soc-drm = "${WESTEROS_REVISION}"
PACKAGE_ARCH_pn-westeros-soc-drm = "${VENDOR_LAYER_EXTENSION}"
SRCREV_pn-westeros-soc-drm = "${WESTEROS_SRCREV}"

PV_pn-westeros = "${WESTEROS_VERSION}"
PR_pn-westeros = "${WESTEROS_REVISION}"
PACKAGE_ARCH_pn-westeros = "${VENDOR_LAYER_EXTENSION}"
SRCREV_pn-westeros = "${WESTEROS_SRCREV}"

PV_pn-essos = "${WESTEROS_VERSION}"
PR_pn-essos = "${WESTEROS_REVISION}"
PACKAGE_ARCH_pn-essos = "${VENDOR_LAYER_EXTENSION}"
SRCREV_pn-essos = "${WESTEROS_SRCREV}"

PV_pn-westeros-sink = "${WESTEROS_VERSION}"
PR_pn-westeros-sink = "${WESTEROS_REVISION}"
PACKAGE_ARCH_pn-westeros-sink = "${VENDOR_LAYER_EXTENSION}"
SRCREV_pn-westeros-sink = "${WESTEROS_SRCREV}"

# RDKV HAL component versions

# RDKV HAL component versions of raspberrypi4
SRCREV_pn-devicesettings-hal-raspberrypi4 = "1.0.0"
PV_pn-devicesettings-hal-raspberrypi4 = "1.0.0"
PR_pn-devicesettings-hal-raspberrypi4 = "r0"
PACKAGE_ARCH_pn-devicesettings-hal-raspberrypi4 = "${VENDOR_LAYER_EXTENSION}"

SRCREV_pn-iarmmgrs-hal-raspberrypi4 = "1.0.0"
PV_pn-iarmmgrs-hal-raspberrypi4 = "1.0.0"
PR_pn-iarmmgrs-hal-raspberrypi4 = "r0"
PACKAGE_ARCH_pn-iarmmgrs-hal-raspberrypi4 = "${VENDOR_LAYER_EXTENSION}"

SRCREV_pn-mfrlibs-hal-raspberrypi4 = "1.0.0"
PV_pn-mfrlibs-hal-raspberrypi4 = "1.0.0"
PR_pn-mfrlibs-hal-raspberrypi4 = "r0"
PACKAGE_ARCH_pn-mfrlibs-hal-raspberrypi4 = "${VENDOR_LAYER_EXTENSION}"

