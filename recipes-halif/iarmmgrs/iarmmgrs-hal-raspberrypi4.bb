DESCRIPTION = "IARMMGRS HAL Implementation - IR"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b1e01b26bacfc2232046c90a330332b3"

PROVIDES = "virtual/iarmmgrs-hal virtual/vendor-iarmmgrs-hal"
RPROVIDES:${PN} = "virtual/iarmmgrs-hal virtual/vendor-iarmmgrs-hal"

SRC_URI = "${CMF_GITHUB_ROOT}/rdkvhal-ir-manager-raspberrypi4;${CMF_GIT_SRC_URI_SUFFIX}"

S = "${WORKDIR}/git"

DEPENDS = "iarmmgrs-hal-headers iarmbus-headers"

inherit autotools coverity

CFLAGS += " \
    -I${STAGING_DIR_TARGET}${includedir}/rdk/iarmmgrs-hal/ \
    "
