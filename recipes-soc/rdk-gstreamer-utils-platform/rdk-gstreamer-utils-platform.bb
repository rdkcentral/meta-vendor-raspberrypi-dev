LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
DEPENDS += "${@bb.utils.contains('DISTRO_FEATURES', 'gstreamer1', 'gstreamer1.0  gstreamer1.0-plugins-base', 'gstreamer gst-plugins-base', d)}"
DEPENDS += "rdk-gstreamer-utils-headers"

SRC_URI = "${CMF_GITHUB_ROOT}/rdk-gstreamer-utils-raspberrypi;${CMF_GITHUB_SRC_URI_SUFFIX}"
S = "${WORKDIR}/git/"

PROVIDES = "virtual/lib32-vendor-rdk-gstreamer-utils-platform"
RPROVIDES:${PN} = "virtual/lib32-vendor-rdk-gstreamer-utils-platform"

CXXFLAGS += "-I${STAGING_INCDIR}/glib-2.0 -I${STAGING_INCDIR}/gstreamer-1.0 -I${STAGING_DIR_TARGET}/${libdir}/glib-2.0/include/ "

inherit autotools pkgconfig

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
