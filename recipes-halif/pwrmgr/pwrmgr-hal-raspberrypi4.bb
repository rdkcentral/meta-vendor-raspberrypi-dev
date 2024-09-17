DESCRIPTION = "PWRMGR HAL Implementation."
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fd707e76aa29b6984fbe80629ec55f78"

PROVIDES += " virtual/vendor-pwrmgr-hal "
RPROVIDES_${PN} += " virtual/vendor-pwrmgr-hal"

SRC_URI = "${CMF_GITHUB_ROOT}/rdkvhal-power-manager-raspberrypi4;${CMF_GIT_SRC_URI_SUFFIX}"

S = "${WORKDIR}/git"

DEPENDS = "iarmbus-headers power-manager-headers"

inherit autotools coverity

CFLAGS += " \
    -I${STAGING_DIR_TARGET}${includedir}/rdk/halif/power-manager/ \
    "
