DESCRIPTION = "deepsleep HAL Implementation."
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b1e01b26bacfc2232046c90a330332b3"

PROVIDES = "virtual/deepsleep-hal virtual/vendor-deepsleep-hal"
RPROVIDES_${PN} += " virtual/vendor-deepsleepmgr-hal "

SRC_URI = "git://github.com/rdkcentral/rdkvhal-deepsleep-manager-raspberrypi4.git;branch=develop;protocol=https"

SRCREV = "de39f83a0fc1471968138031c7d77ba463e5831f" 

S = "${WORKDIR}/git"

DEPENDS = "iarmbus-headers deepsleep-manager-headers"

inherit autotools coverity

CFLAGS += " \
    -I${STAGING_DIR_TARGET}${includedir}/rdk/halif/deepsleep-manager/ \
    "
