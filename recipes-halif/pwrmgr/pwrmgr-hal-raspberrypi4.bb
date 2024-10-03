DESCRIPTION = "PWRMGR HAL Implementation."
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b1e01b26bacfc2232046c90a330332b3"

PROVIDES += " virtual/vendor-pwrmgr-hal "
RPROVIDES_${PN} += " virtual/vendor-pwrmgr-hal"

#SRC_URI = "${CMF_GITHUB_ROOT}/rdkvhal-power-manager-raspberrypi4;${CMF_GIT_SRC_URI_SUFFIX}"

SRC_URI = "https://github.com/Mallikarjunm6316/rdkvhal-power-manager-raspberrypi4;branch=develop;protocol=https"

SRCREV = "5cae2b8ee02235472321272e4e25268e54c65280"

S = "${WORKDIR}/git"

DEPENDS = "iarmbus-headers power-manager-headers"

inherit autotools coverity

CFLAGS += " \
    -I${STAGING_DIR_TARGET}${includedir}/rdk/halif/power-manager/ \
    "
