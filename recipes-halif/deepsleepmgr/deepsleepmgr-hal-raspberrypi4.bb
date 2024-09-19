DESCRIPTION = "deepsleep HAL Implementation."
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b1e01b26bacfc2232046c90a330332b3"

PROVIDES = "virtual/deepsleep-hal virtual/vendor-deepsleep-hal"
RPROVIDES_${PN} += " virtual/vendor-deepsleepmgr-hal "

SRC_URI = "git://github.com/Mallikarjunm6316/rdkvhal-deepsleep-manager-raspberrypi4.git;branch=develop;protocol=https"

SRCREV = "d47a1e3763aee4d97947968ea61d28fe2cf3078a" 

S = "${WORKDIR}/git"

DEPENDS = "iarmbus-headers deepsleep-manager-headers"

inherit autotools coverity

CFLAGS += " \
    -I${STAGING_DIR_TARGET}${includedir}/rdk/halif/deepsleep-manager/ \
    "
