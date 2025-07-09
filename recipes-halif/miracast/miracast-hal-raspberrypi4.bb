SUMMARY = "Recipe for Miracast HAL"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "${CMF_GITHUB_ROOT}/rdkvhal-miracast-raspberrypi4;${CMF_GIT_SRC_URI_SUFFIX}"

S = "${WORKDIR}/git"

PROVIDES = "virtual/vendor-miracast-soc"
RPROVIDES:${PN} = "virtual/vendor-miracast-soc"

inherit pkgconfig cmake

FILES:${PN} += "${libdir}/*.so"
#FILES_SOLIBSDEV = ""
#INSANE_SKIP:${PN} += "dev-so"
