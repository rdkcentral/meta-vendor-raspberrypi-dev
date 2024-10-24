DESCRIPTION = "mfrlibs implementation for RaspberryPi"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=175792518e4ac015ab6696d16c4f607e"

DEPENDS = "iarmmgrs-hal-headers iarmbus-headers"

SRC_URI = "${CMF_GITHUB_ROOT}/rdkvhal-mfrlibs-raspberrypi4;${CMF_GIT_SRC_URI_SUFFIX}"

S = "${WORKDIR}/git"

PROVIDES = "virtual/mfrlib"
RPROVIDES_${PN} = "virtual/mfrlib"

EXTRA_OECONF += "--enable-thermalprotection"

inherit autotools coverity

do_install_append() {
    # Provide FlashApp support
    install -d ${D}${bindir}
    install -m 0755 ${S}/FlashApp.sh ${D}${bindir}/FlashApp.sh
    ln -sf ${D}${bindir}/FlashApp.sh ${D}${bindir}/FlashApp
}

FILES_${PN} += "${bindir}/*"
