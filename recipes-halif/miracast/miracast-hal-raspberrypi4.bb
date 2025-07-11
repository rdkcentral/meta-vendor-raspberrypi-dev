SUMMARY = "Recipe for Miracast HAL"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "${CMF_GITHUB_ROOT}/rdkvhal-miracast-raspberrypi4;${CMF_GIT_SRC_URI_SUFFIX}"

S = "${WORKDIR}/git"

PROVIDES = "virtual/vendor-miracast-soc"
RPROVIDES:${PN} = "virtual/vendor-miracast-soc"

inherit pkgconfig cmake

DEPENDS = "${@bb.utils.contains('DISTRO_FEATURES', 'gstreamer1', 'gstreamer1.0  gstreamer1.0-plugins-base', 'gstreamer gst-plugins-base', d)}"
RDEPENDS:${PN} = "${@bb.utils.contains('DISTRO_FEATURES', 'gstreamer1', 'gstreamer1.0  gstreamer1.0-plugins-base', 'gstreamer gst-plugins-base', d)}"

# Inhibit Yocto's auto-generation of library package with different name.
AUTO_LIBNAME_PKGS = ""
