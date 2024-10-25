SUMMARY = "A small image just capable of allowing a device to boot."

# https://github.com/rdk-e/meta-rdk-oss-reference/pull/335
# Change 'ca-certificates-default-certs' to 'virtual/ca-certificates-trust-store' when OSS release provides it.

IMAGE_INSTALL = " \
                 packagegroup-core-boot \
                 ${CORE_IMAGE_EXTRA_INSTALL} \
                 packagegroup-vendor-layer \
                 ca-certificates-default-certs \
                 dropbear \
                "

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE ?= "8192"
IMAGE_ROOTFS_EXTRA_SPACE:append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "" ,d)}"
