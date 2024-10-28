SUMMARY = "HDMI CEC HAL Implementation for RPI-4 "
SECTION = "console/utils"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "${CMF_GITHUB_ROOT}/rdkvhal-hdmicec-raspberrypi4;${CMF_GIT_SRC_URI_SUFFIX}"

S = "${WORKDIR}/git"

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
