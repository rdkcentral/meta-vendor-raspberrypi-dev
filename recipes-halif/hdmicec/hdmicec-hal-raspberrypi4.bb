SUMMARY = "HDMI CEC HAL Implementation for RPI-4 "
SECTION = "console/utils"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "${CMF_GITHUB_ROOT}/rdkvhal-hdmicec-raspberrypi4;${CMF_GIT_SRC_URI_SUFFIX}"

S = "${WORKDIR}/git"

PROVIDES = "virtual/hdmicec-hal"
RPROVIDES_${PN} = "virtual/hdmicec-hal"

DEPENDS = "hdmicecheader"

do_compile() {
    oe_runmake -C ${S}/ -f Makefile clean
    oe_runmake -C ${S}/ -f Makefile
}

do_install() {
    install -d ${D}${libdir}/
    install -m 644 ${S}/libRCECHal.so ${D}${libdir}/
}

PACKAGES = "${PN} ${PN}-dev ${PN}-dbg"

FILES_${PN} += "${libdir}/lib*.so"
FILES_${PN}-dbg +="${libdir}/.debug/*"

INSANE_SKIP_${PN} += "ldflags"
