LICENSE = "CLOSED"
LIC_FILES_CHKSUM = "file://LICENSE;md5=175792518e4ac015ab6696d16c4f607e"

DEPENDS += "${@bb.utils.contains('DISTRO_FEATURES', 'gstreamer1', 'gstreamer1.0  gstreamer1.0-plugins-base', 'gstreamer gst-plugins-base', d)}"
DEPENDS += "rdk-gstreamer-utils-headers"

SRC_URI = "git://git@github.com/ssadha725_comcast/rdk-gstreamer-utils-raspberrypi;${RDKE_GITHUB_SRC_URI_SUFFIX}"
SRCREV = "a03aeef1c5978ab3c765307218f1b7b7c25616dd"
S = "${WORKDIR}/git/"


CXXFLAGS += "-I${STAGING_INCDIR}/glib-2.0 -I${STAGING_INCDIR}/gstreamer-1.0 -I${STAGING_DIR_TARGET}/${libdir}/glib-2.0/include/ "

inherit autotools pkgconfig features_check

do_compile () {
    oe_runmake -C ${S} -f Makefile
}

do_install() {
        install -d ${D}/${libdir}
        install -d ${D}/usr/include
        install -m 0755 ${S}/librdkgstreamerutilsplatform.so ${D}/${libdir}
}


INSANE_SKIP:${PN} = "dev-so"
FILES_SOLIBSDEV = ""
FILES:${PN} += "${libdir}/*.so"

INSANE_SKIP:${PN} += "ldflags textrel"
