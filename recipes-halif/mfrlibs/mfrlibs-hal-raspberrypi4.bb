DESCRIPTION = "mfrlibs implementation for RaspberryPi"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=175792518e4ac015ab6696d16c4f607e"

DEPENDS = "iarmmgrs-hal-headers iarmbus-headers"

SRC_URI = "${CMF_GITHUB_ROOT}/rdkvhal-mfrlibs-raspberrypi4;${CMF_GIT_SRC_URI_SUFFIX}"

S = "${WORKDIR}/git"

PROVIDES = "virtual/mfrlib"
RPROVIDES:${PN} = "virtual/mfrlib"

EXTRA_OECONF += "--enable-thermalprotection"
## Enable to limit mfrhal library runtime to single instance if required
#EXTRA_OECONF += "--enable-single-instance-lock"

inherit autotools coverity

do_install:append() {
    # Provide FlashApp support
    install -d ${D}${bindir}
    install -m 0755 ${S}/FlashApp.sh ${D}${bindir}/FlashApp.sh
    ln -sr ${D}${bindir}/FlashApp.sh ${D}${bindir}/FlashApp
}

FILES_SOLIBSDEV = ""
FILES:${PN} += "${libdir}/*.so ${bindir}/*"
INSANE_SKIP:${PN} += "dev-so"
