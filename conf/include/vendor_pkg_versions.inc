# This layer shall be common for all RPi variants.

#Linux kernel components

PR:pn-linux-libc-headers = "r0"
PACKAGE_ARCH:pn-linux-libc-headers = "${VENDOR_LAYER_EXTENSION}"

PV:pn-android-raspberrypi = "5.15.92"
PR:pn-android-raspberrypi = "r0"
PACKAGE_ARCH:pn-android-raspberrypi = "${VENDOR_LAYER_EXTENSION}"
PREFERRED_VERSION_android-raspberrypi = "5.15.%"

PV:pn-packagegroup-kernel-modules-raspberrypi4 = "5.15.92"
PR:pn-packagegroup-kernel-modules-raspberrypi4 = "r0"
PACKAGE_ARCH:pn-packagegroup-kernel-modules-raspberrypi4 = "${VENDOR_LAYER_EXTENSION}"

PV:pn-linux-firmware-rpidistro = "1.0.0"
PR:pn-linux-firmware-rpidistro = "r0"
PACKAGE_ARCH:pn-linux-firmware-rpidistro = "${VENDOR_LAYER_EXTENSION}"

#Platform components

PV:pn-bluez-firmware-rpidistro = "1.0.0"
PR:pn-bluez-firmware-rpidistro = "r0"
PACKAGE_ARCH:pn-bluez-firmware-rpidistro = "${VENDOR_LAYER_EXTENSION}"

PV:pn-userland = "20220323"
PR:pn-userland = "r0"
PACKAGE_ARCH:pn-userland = "${VENDOR_LAYER_EXTENSION}"

PV:pn-pi-bluetooth = "0.1.17"
PR:pn-pi-bluetooth = "r0"
PACKAGE_ARCH:pn-pi-bluetooth = "${VENDOR_LAYER_EXTENSION}"

PV:pn-udev-rules-rpi = "1.0"
PR:pn-udev-rules-rpi = "r0"
PACKAGE_ARCH:pn-udev-rules-rpi = "${VENDOR_LAYER_EXTENSION}"

#OSS Components

PV:pn-libepoxy = "1.5.9"
PR:pn-libepoxy = "r0"
PACKAGE_ARCH:pn-libepoxy = "${VENDOR_LAYER_EXTENSION}"

PV:pn-make-mod-scripts = "1.0"
PR:pn-make-mod-scripts = "r0"
PACKAGE_ARCH:pn-make-mod-scripts = "${VENDOR_LAYER_EXTENSION}"

PV:pn-cairo = "1.16.0"
PR:pn-cairo = "r1"
PACKAGE_ARCH:pn-cairo = "${VENDOR_LAYER_EXTENSION}"

#PV:pn-libdrm = "2.4.110"
PR:pn-libdrm = "r0"
PACKAGE_ARCH:pn-libdrm = "${VENDOR_LAYER_EXTENSION}"

PV:pn-mesa = "22.0.3"
PR:pn-mesa = "r0"
PACKAGE_ARCH:pn-mesa = "${VENDOR_LAYER_EXTENSION}"
PACKAGE_ARCH:pn-libegl-mesa = "${VENDOR_LAYER_EXTENSION}"
PACKAGE_ARCH:pn-libgles2-mesa = "${VENDOR_LAYER_EXTENSION}"
PACKAGE_ARCH:pn-libgl-mesa = "${VENDOR_LAYER_EXTENSION}"
PACKAGE_ARCH:pn-libgbm = "${VENDOR_LAYER_EXTENSION}"

PV:pn-librsvg = "2.40.21"
PR:pn-librsvg = "r0"
PACKAGE_ARCH:pn-librsvg = "${VENDOR_LAYER_EXTENSION}"

PV:pn-mpg123 = "1.29.3"
PR:pn-mpg123 = "r0"
PACKAGE_ARCH:pn-mpg123 = "${VENDOR_LAYER_EXTENSION}"

PV:pn-pango = "1.44.7"
PR:pn-pango = "r0"
PACKAGE_ARCH:pn-pango = "${VENDOR_LAYER_EXTENSION}"

PV:pn-pulseaudio = "15.0"
PR:pn-pulseaudio = "r0"
PACKAGE_ARCH:pn-pulseaudio = "${VENDOR_LAYER_EXTENSION}"

PV:pn-libmms = "0.6.4"
PR:pn-libmms = "r0"
PACKAGE_ARCH:pn-libmms = "${VENDOR_LAYER_EXTENSION}"

PV:pn-alsa-plugins = "1.2.6"
PR:pn-alsa-plugins = "r0"
PACKAGE_ARCH:pn-alsa-plugins = "${VENDOR_LAYER_EXTENSION}"

#Gstreamer components

GST_VERSION = "1.18.5"
GST_REVISION = "r0"

PV:pn-gstreamer1.0 = "${GST_VERSION}"
PR:pn-gstreamer1.0 = "${GST_REVISION}"
PACKAGE_ARCH:pn-gstreamer1.0 = "${VENDOR_LAYER_EXTENSION}"
PREFERRED_VERSION_gstreamer1.0 ?= "${GST_VERSION}"

PV:pn-gstreamer1.0-plugins-base = "${GST_VERSION}"
PR:pn-gstreamer1.0-plugins-base = "${GST_REVISION}"
PACKAGE_ARCH:pn-gstreamer1.0-plugins-base = "${VENDOR_LAYER_EXTENSION}"
PREFERRED_VERSION_gstreamer1.0-plugins-base ?= "${GST_VERSION}"

PV:pn-gstreamer1.0-plugins-base-meta = "${GST_VERSION}"
PR:pn-gstreamer1.0-plugins-base-meta = "${GST_REVISION}"
PACKAGE_ARCH:pn-gstreamer1.0-plugins-base-meta = "${VENDOR_LAYER_EXTENSION}"
PREFERRED_VERSION_gstreamer1.0-plugins-base-meta ?= "${GST_VERSION}"

PV:pn-gstreamer1.0-libav = "${GST_VERSION}"
PR:pn-gstreamer1.0-libav = "${GST_REVISION}"
PACKAGE_ARCH:pn-gstreamer1.0-libav = "${VENDOR_LAYER_EXTENSION}"
PREFERRED_VERSION_gstreamer1.0-libav ?= "${GST_VERSION}"

PV:pn-gstreamer1.0-plugins-good = "${GST_VERSION}"
PR:pn-gstreamer1.0-plugins-good = "${GST_REVISION}"
PACKAGE_ARCH:pn-gstreamer1.0-plugins-good = "${VENDOR_LAYER_EXTENSION}"
PREFERRED_VERSION_gstreamer1.0-plugins-good ?= "${GST_VERSION}"

PV:pn-gstreamer1.0-plugins-good-meta = "${GST_VERSION}"
PR:pn-gstreamer1.0-plugins-good-meta = "${GST_REVISION}"
PACKAGE_ARCH:pn-gstreamer1.0-plugins-good-meta = "${VENDOR_LAYER_EXTENSION}"
PREFERRED_VERSION_gstreamer1.0-plugins-good-meta ?= "${GST_VERSION}"

PV:pn-gstreamer1.0-plugins-bad = "${GST_VERSION}"
PR:pn-gstreamer1.0-plugins-bad = "${GST_REVISION}"
PACKAGE_ARCH:pn-gstreamer1.0-plugins-bad = "${VENDOR_LAYER_EXTENSION}"
PREFERRED_VERSION_gstreamer1.0-plugins-bad ?= "${GST_VERSION}"

PV:pn-gstreamer1.0-plugins-bad-meta = "${GST_VERSION}"
PR:pn-gstreamer1.0-plugins-bad-meta = "${GST_REVISION}"
PACKAGE_ARCH:pn-gstreamer1.0-plugins-bad-meta = "${VENDOR_LAYER_EXTENSION}"
PREFERRED_VERSION_gstreamer1.0-plugins-bad-meta ?= "${GST_VERSION}"

PV:pn-gstreamer1.0-rtsp-server = "${GST_VERSION}"
PR:pn-gstreamer1.0-rtsp-server = "${GST_REVISION}"
PACKAGE_ARCH:pn-gstreamer1.0-rtsp-server = "${VENDOR_LAYER_EXTENSION}"
PREFERRED_VERSION_gstreamer1.0-rtsp-server ?= "${GST_VERSION}"

# Westeros components
WESTEROS_VERSION = "1.1.58"
WESTEROS_REVISION = "r0"
# Tip of westeros master as of Feb 28, 2025
WESTEROS_SRCREV = "547f03bf45c32c026e0931b9882323fc4e559618"

PV:pn-westeros-simplebuffer = "${WESTEROS_VERSION}"
PR:pn-westeros-simplebuffer = "${WESTEROS_REVISION}"
PACKAGE_ARCH:pn-westeros-simplebuffer = "${VENDOR_LAYER_EXTENSION}"
SRCREV:pn-westeros-simplebuffer = "${WESTEROS_SRCREV}"

PV:pn-westeros-simpleshell = "${WESTEROS_VERSION}"
PR:pn-westeros-simpleshell = "${WESTEROS_REVISION}"
PACKAGE_ARCH:pn-westeros-simpleshell = "${VENDOR_LAYER_EXTENSION}"
SRCREV:pn-westeros-simpleshell = "${WESTEROS_SRCREV}"

PV:pn-westeros-soc-drm = "${WESTEROS_VERSION}"
PR:pn-westeros-soc-drm = "${WESTEROS_REVISION}"
PACKAGE_ARCH:pn-westeros-soc-drm = "${VENDOR_LAYER_EXTENSION}"
SRCREV:pn-westeros-soc-drm = "${WESTEROS_SRCREV}"

PV:pn-westeros = "${WESTEROS_VERSION}"
PR:pn-westeros = "${WESTEROS_REVISION}"
PACKAGE_ARCH:pn-westeros = "${VENDOR_LAYER_EXTENSION}"
SRCREV:pn-westeros = "${WESTEROS_SRCREV}"

PV:pn-essos = "${WESTEROS_VERSION}"
PR:pn-essos = "${WESTEROS_REVISION}"
PACKAGE_ARCH:pn-essos = "${VENDOR_LAYER_EXTENSION}"
SRCREV:pn-essos = "${WESTEROS_SRCREV}"

PV:pn-westeros-sink = "${WESTEROS_VERSION}"
PR:pn-westeros-sink = "${WESTEROS_REVISION}"
PACKAGE_ARCH:pn-westeros-sink = "${VENDOR_LAYER_EXTENSION}"
SRCREV:pn-westeros-sink = "${WESTEROS_SRCREV}"

PV:pn-wayland-default-egl = "1.20.0"
PR:pn-wayland-default-egl = "r0"
PACKAGE_ARCH:pn-wayland-default-egl = "${VENDOR_LAYER_EXTENSION}"

# RDKV HAL component versions

# RDKV HAL component versions of raspberrypi4
SRCREV:pn-devicesettings-hal-raspberrypi4 = "ff90c889922c2cac6b8971cccb10101cb9499c5e"
PV:pn-devicesettings-hal-raspberrypi4 = "1.1.1"
PR:pn-devicesettings-hal-raspberrypi4 = "r0"
PACKAGE_ARCH:pn-devicesettings-hal-raspberrypi4 = "${VENDOR_LAYER_EXTENSION}"

SRCREV:pn-hdmicec-hal-raspberrypi4 = "c993538b4bdaf28c9a63292ba6182c34c9a4b48c"
PV:pn-hdmicec-hal-raspberrypi4 = "1.0.2"
PR:pn-hdmicec-hal-raspberrypi4 = "r0"
PACKAGE_ARCH:pn-hdmicec-hal-raspberrypi4 = "${VENDOR_LAYER_EXTENSION}"

SRCREV:pn-iarmmgrs-hal-raspberrypi4 = "f7c7d360fd856e06b65097333e77a0c1c5d313ea"
PV:pn-iarmmgrs-hal-raspberrypi4 = "2.0.1"
PR:pn-iarmmgrs-hal-raspberrypi4 = "r0"
PACKAGE_ARCH:pn-iarmmgrs-hal-raspberrypi4 = "${VENDOR_LAYER_EXTENSION}"

SRCREV:pn-pwrmgr-hal-raspberrypi4 = "26059d4d242723384a86133817590558c4fac90c"
PV:pn-pwrmgr-hal-raspberrypi4 = "1.2.0"
PR:pn-pwrmgr-hal-raspberrypi4 = "r0"
PACKAGE_ARCH:pn-pwrmgr-hal-raspberrypi4 = "${VENDOR_LAYER_EXTENSION}"

SRCREV:pn-deepsleepmgr-hal-raspberrypi4 = "5299b42a8bf4c462303e77caf2d0441057929e62"
PV:pn-deepsleepmgr-hal-raspberrypi4 = "1.0.0"
PR:pn-deepsleepmgr-hal-raspberrypi4 = "r0"
PACKAGE_ARCH:pn-deepsleepmgr-hal-raspberrypi4 = "${VENDOR_LAYER_EXTENSION}"

SRCREV:pn-mfrlibs-hal-raspberrypi4 = "0c8b6a05a73aace7bd4c83780abbcff67661c3f2"
PV:pn-mfrlibs-hal-raspberrypi4 = "1.1.0"
PR:pn-mfrlibs-hal-raspberrypi4 = "r0"
PACKAGE_ARCH:pn-mfrlibs-hal-raspberrypi4 = "${VENDOR_LAYER_EXTENSION}"

SRCREV:pn-sysint-soc = "0c9bfecbca9830b94ae83ae608458b7e26a630a1"
PV:pn-sysint-soc = "1.1.4"
PR:pn-sysint-soc = "r0"
PACKAGE_ARCH:pn-sysint-soc = "${VENDOR_LAYER_EXTENSION}"

SRCREV:pn-systemaudioplatform = "59662783df1c0c7d04016c6f90da27516c070109"
PV:pn-systemaudioplatform = "1.0.0"
PR:pn-systemaudioplatform = "r0"
PACKAGE_ARCH:pn-systemaudioplatform = "${VENDOR_LAYER_EXTENSION}"

SRCREV:pn-rdk-gstreamer-utils-platform = "22372e73f4450e290df41d6cf4c61af264c44f76"
PV:pn-rdk-gstreamer-utils-platform = "1.0.0"
PR:pn-rdk-gstreamer-utils-platform = "r0"
PACKAGE_ARCH:pn-rdk-gstreamer-utils-platform = "${VENDOR_LAYER_EXTENSION}"

SRCREV:pn-audio-service-rpi = "1.0"
PV:pn-audio-service-rpi = "1.0"
PR:pn-audio-service-rpi = "r0"
PACKAGE_ARCH:pn-audio-service-rpi = "${VENDOR_LAYER_EXTENSION}"

SRCREV:pn-gst-drm-plugins-rpi = "1.0"
PV:pn-gst-drm-plugins-rpi = "1.0"
PR:pn-gst-drm-plugins-rpi = "r0"
PACKAGE_ARCH:pn-gst-drm-plugins-rpi = "${VENDOR_LAYER_EXTENSION}"

SRCREV:pn-secapi2-adapter-rpi  = "1.0"
PV:pn-secapi2-adapter-rpi  = "1.0"
PR:pn-secapi2-adapter-rpi  = "r0"
PACKAGE_ARCH:pn-secapi2-adapter-rpi  = "${VENDOR_LAYER_EXTENSION}"

PREFERRED_VERSION_ffmpeg = "4.2.2"
PR:pn-ffmpeg = "r1"
PACKAGE_ARCH:pn-ffmpeg = "${VENDOR_LAYER_EXTENSION}"

PV:pn-apparmor-vendor = "1.0.1"
PR:pn-apparmor-vendor = "r0"
PACKAGE_ARCH:pn-apparmor-vendor = "${VENDOR_LAYER_EXTENSION}"
SRCREV:pn-apparmor-vendor = "707f854ceea15919a2495db32c6ca5ef75e8b43b"
SRCREV_rdk-apparmor-profiles:pn-apparmor-vendor = "6b493ce3338e64e8a66224942d6af84b440d52c9"

SRCREV:pn-displayinfo-soc = "d093b726b7078ba5495c4c4dc524295ff0da94ea"
PV:pn-displayinfo-soc = "1.0.0"
PR:pn-displayinfo-soc = "r0"
PACKAGE_ARCH:pn-displayinfo-soc = "${VENDOR_LAYER_EXTENSION}"
