DESCRIPTION = "IARMMGRS HAL Implementation - IR"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b1e01b26bacfc2232046c90a330332b3"

PROVIDES = "virtual/iarmmgrs-hal virtual/vendor-iarmmgrs-hal"
RPROVIDES_${PN} = "virtual/iarmmgrs-hal virtual/vendor-iarmmgrs-hal"

# Future: RDK-48312 says IARMMGRS HAL will be split into Power & DeepSleep.
# Rename this recipe as Power Manager HAL when this happens and introduce another for DeepSleep.
# IR Manager will get deprecated and replaced by udev or similar.
# Till then this will provide HAL implementation for all 3; IR, Power & DeepSleep.

#SRC_URI = "${CMF_GITHUB_ROOT}/rdkvhal-power-manager-raspberrypi4;${CMF_GIT_SRC_URI_SUFFIX}"

SRC_URI = "git://github.com/Mallikarjunm6316/rdkvhal-ir-manager-raspberrypi4.git;branch=develop;protocol=https"

SRCREV = "e8703d9e1313fbb6003acb13354bb568cce3f28d"

S = "${WORKDIR}/git"

DEPENDS = "iarmmgrs-hal-headers iarmbus-headers"

inherit autotools coverity

CFLAGS += " \
    -I${STAGING_DIR_TARGET}${includedir}/rdk/iarmmgrs-hal/ \
    "

EXTRA_OECONF += "--enable-dsleep"

