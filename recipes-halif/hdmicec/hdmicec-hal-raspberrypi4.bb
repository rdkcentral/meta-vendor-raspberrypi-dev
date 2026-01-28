SUMMARY = "HDMI CEC HAL Implementation for RPI-4 "
SECTION = "console/utils"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "${CMF_GITHUB_ROOT}/rdkvhal-hdmicec-raspberrypi4;${CMF_GIT_SRC_URI_SUFFIX}"

S = "${WORKDIR}/git"

DEPENDS += "${@bb.utils.contains('MACHINE_FEATURES', 'vc4graphics', 'userland', '', d)}"

INCLUDE_DIRS = " \
    -I${STAGING_DIR_TARGET}${includedir}/rdk/halif/ds-hal/ \
    -I${STAGING_DIR_TARGET}${includedir}/interface/vmcs_host/ \
    "

PROVIDES = " \
    virtual/hdmicec-hal \
    virtual/vendor-hdmicec-hal \
    "

RPROVIDES:${PN} = " \
    virtual/hdmicec-hal \
    virtual/vendor-hdmicec-hal \
    "

DEPENDS = "hdmicecheader"

inherit cmake

FILES:${PN} += "${libdir}/*.so"
FILES_SOLIBSDEV = ""
INSANE_SKIP:${PN} += "dev-so"
