SUMMARY = "System Audio platform specific code"
LICENSE = "Apache-2.0"

LIC_FILES_CHKSUM = "file://../LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

DEPENDS += "${@bb.utils.contains('DISTRO_FEATURES', 'gstreamer1', 'gstreamer1.0  gstreamer1.0-plugins-base', 'gstreamer gst-plugins-base', d)}"
SRC_URI = "${CMF_GITHUB_ROOT}/rdkvhal-systemaudioplatform-raspberrypi4;${CMF_GIT_SRC_URI_SUFFIX}"

S = "${WORKDIR}/git/systemaudioplatform/"
inherit cmake pkgconfig

FILES:${PN} = "/usr/lib/libsystemaudioplatform.so.*"
FILES:${PN}-dev = "/usr/lib/libsystemaudioplatform.so /usr/include/systemaudioplatform.h"
