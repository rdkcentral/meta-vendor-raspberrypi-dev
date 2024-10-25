# Version and SRCREV for this component is handled in conf/include/rdk-headers-versions.inc

SUMMARY = "Devicesettings HAL Implementation for RPI-4"
SECTION = "console/utils"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=175792518e4ac015ab6696d16c4f607e"

PROVIDES = "virtual/devicesettings-hal virtual/vendor-devicesettings-hal"
RPROVIDES:${PN} = "virtual/devicesettings-hal virtual/vendor-devicesettings-hal"

# a HAL is machine specific
PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "${CMF_GITHUB_ROOT}/rdkvhal-devicesettings-raspberrypi4;${CMF_GIT_SRC_URI_SUFFIX}"

S = "${WORKDIR}/git"

DEPENDS = "devicesettings-hal-headers virtual/egl alsa-lib"

# mesa is the egl provider for vc4graphics
# but HAL implementation requires headers from userland
DEPENDS += "${@bb.utils.contains('MACHINE_FEATURES', 'vc4graphics', 'userland', '', d)}"

INCLUDE_DIRS = " \
    -I${STAGING_DIR_TARGET}${includedir}/rdk/halif/ds-hal/ \
    "

# note: we really on 'make -e' to control LDFLAGS and CFLAGS from here. This is
# far from ideal, but this is to workaround the current component Makefile
CFLAGS += "-fPIC -D_REENTRANT -Wall ${INCLUDE_DIRS}"

export DSHAL_API_MAJOR_VERSION = '0'
export DSHAL_API_MINOR_VERSION = '0'

FILES:${PN} += "${libdir}/*.so*"
FILES:${PN} += "/opt/www/*.html"
FILES:${PN} += "/opt/persistent/ds/"
FILES:${PN} += "/opt/persistent/ds/*"
FILES:${PN} += "/lib/rdk/*"
FILES:${PN} += "/lib/systemd/system/*"

#inherit coverity systemd pkgconfig
inherit systemd

do_compile() {
    oe_runmake -C ${S}/ -f Makefile clean
    oe_runmake -C ${S}/ -f Makefile
}

do_install() {
    # Install our HAL .h files required by the 'generic' devicesettings
    cd ${S}
    install -d ${D}${includedir}/rdk/halif/ds-hal
    for i in *Settings.h ; do
        install -m 0644 $i ${D}${includedir}/rdk/halif/ds-hal
    done
    install -d ${D}${libdir}
    oe_soinstall ${S}/libds-hal.so.${DSHAL_API_MAJOR_VERSION}.${DSHAL_API_MINOR_VERSION} ${D}${libdir}
    install -d ${D}${bindir}
    install -m 0644 ${S}/platform.cfg ${D}${bindir}
    install -d ${D}${base_libdir}/rdk
    install -d ${D}${base_libdir}/systemd/system
    install -d ${D}/opt/persistent/ds
    install -m 0755 ${S}/hostData ${D}/opt/persistent/ds/
    install -m 0755 ${S}/scripts/rpiDisplayEnable.sh ${D}/lib/rdk/rpiDisplayEnable.sh
    install -m 0644 ${S}/systemd/rpiDisplay.service ${D}/lib/systemd/system/rpiDisplay.service
}

SYSTEMD_SERVICE:${PN} += "rpiDisplay.service"

# Fix the QA warning.
INSANE_SKIP:${PN} = "ldflags"
INSANE_SKIP:${PN}-dev = "ldflags"

