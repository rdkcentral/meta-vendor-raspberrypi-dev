DESCRIPTION = "PWRMGR HAL Implementation."
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b1e01b26bacfc2232046c90a330332b3"

PROVIDES += " virtual/vendor-pwrmgr-hal "
RPROVIDES_${PN} += " virtual/vendor-pwrmgr-hal"

SRC_URI = "git://github.com/Mallikarjunm6316/rdkvhal-power-manager-raspberrypi4.git;branch=develop;protocol=https"

SRCREV = "9f3742d35b5f7b01acd8c604780632badb2c0491"

S = "${WORKDIR}/git"

DEPENDS = "iarmbus-headers power-manager-headers"

inherit autotools coverity

CFLAGS += " \
    -I${STAGING_DIR_TARGET}${includedir}/rdk/halif/power-manager/ \
    "
