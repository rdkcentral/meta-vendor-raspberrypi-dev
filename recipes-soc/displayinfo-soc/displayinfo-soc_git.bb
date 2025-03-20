SUMMARY = "DisplayInfo SOC specific code for RaspberryPi"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dc6e390ad71aef79d0c2caf3cde03a19"

inherit cmake pkgconfig

PROVIDES += "virtual/vendor-displayinfo-soc"
RPROVIDES:${PN} = "virtual/vendor-displayinfo-soc"

DEPENDS += "libdrm"
RDEPENDS:${PN} += "libdrm"

SRC_URI = "${CMF_GITHUB_ROOT}/rdkvhal-rdkservices-raspberrypi4;${CMF_GITHUB_SRC_URI_SUFFIX}"

S = "${WORKDIR}/git/DisplayInfo"

FILES_SOLIBSDEV = ""
SOLIBS = ".so"
INSANE_SKIP:${PN} += "dev-so"

ALLOW_EMPTY:${PN} = "1"

FILES:${PN} += "${libdir}/libdisplayinfo-soc.so"
FILES:${PN} += "${libdir}/*.so"
