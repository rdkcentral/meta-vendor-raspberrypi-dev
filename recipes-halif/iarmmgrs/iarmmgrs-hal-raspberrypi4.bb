DESCRIPTION = "IARMMGRS HAL Implementation - IR, Power & Deepsleep."
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b1e01b26bacfc2232046c90a330332b3"

PROVIDES = "virtual/iarmmgrs-hal virtual/vendor-iarmmgrs-hal"
RPROVIDES_${PN} = "virtual/iarmmgrs-hal virtual/vendor-iarmmgrs-hal"

# Future: RDK-48312 says IARMMGRS HAL will be split into Power & DeepSleep.
# Rename this recipe as Power Manager HAL when this happens and introduce another for DeepSleep.
# IR Manager will get deprecated and replaced by udev or similar.
# Till then this will provide HAL implementation for all 3; IR, Power & DeepSleep.

SRC_URI = "${CMF_GITHUB_ROOT}/rdkvhal-power-manager-raspberrypi4;${CMF_GIT_SRC_URI_SUFFIX}"

S = "${WORKDIR}/git"

DEPENDS = "iarmmgrs-hal-headers iarmbus-headers power-manager-headers deepsleep-manager-headers"

inherit autotools coverity

CFLAGS += " \
    -I${STAGING_DIR_TARGET}${includedir}/rdk/halif/power-manager/ \
    -I${STAGING_DIR_TARGET}${includedir}/rdk/halif/deepsleep-manager/ \
    -I${STAGING_DIR_TARGET}${includedir}/rdk/iarmmgrs-hal/ \
    "

EXTRA_OECONF += "--enable-dsleep"

