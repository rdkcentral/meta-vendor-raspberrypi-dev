DESCRIPTION = "deepsleep HAL Implementation."
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b1e01b26bacfc2232046c90a330332b3"

PROVIDES = "virtual/deepsleep-hal virtual/vendor-deepsleep-hal"
RPROVIDES_${PN} += " virtual/vendor-deepsleepmgr-hal "

#SRC_URI = "${CMF_GITHUB_ROOT}/rdkvhal-deepsleep-manager-raspberrypi4;${CMF_GIT_SRC_URI_SUFFIX}"

SRC_URI = "https://github.com/Mallikarjunm6316/rdkvhal-deepsleep-manager-raspberrypi4;sha256sum=cf7c8fd1c7a0a56f662ea8ed6d6ab6aab7b4483e0a28a23bb463d1acf2c1bbbc;branch=develop;protocol=https"

SRCREV = "b079260ee057fb02f0bef2c8201cb2c2141c8663"

S = "${WORKDIR}/git"

DEPENDS = "iarmbus-headers deepsleep-manager-headers"

inherit autotools coverity

IMAGE_INSTALL += "lib32-deepsleepmgr-hal-raspberrypi4"

CFLAGS += " \
    -I${STAGING_DIR_TARGET}${includedir}/rdk/halif/deepsleep-manager/ \
    "
