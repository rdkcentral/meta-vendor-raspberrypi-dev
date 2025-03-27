SUMMARY = "Vendor bootable image which can be flashed on boot media for vendor layer testing and validation."

IMAGE_INSTALL = " \
                 packagegroup-core-boot \
                 ${CORE_IMAGE_EXTRA_INSTALL} \
                 packagegroup-vendor-layer \
                "

# Additional packages added as part of test framework requirement.
# 'virtual/ca-certificates-trust-store' is provided from OSS pkggrp.
# Ref: https://github.com/rdk-e/meta-rdk-oss-reference/commit/f0e7e8081cdb96735c8216282273d928f6501fd6.
IMAGE_INSTALL += " \
                 virtual/ca-certificates-trust-store \
                 dropbear \
                 network-setup \
                "

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE ?= "8192"
IMAGE_ROOTFS_EXTRA_SPACE:append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "" ,d)}"

# RDKEMW-2939: Remove symlinks for /etc/resolv.conf in Vendor, udhcpc populates the value in Vendor
ROOTFS_POSTPROCESS_COMMAND:remove += " create_NM_link; "
