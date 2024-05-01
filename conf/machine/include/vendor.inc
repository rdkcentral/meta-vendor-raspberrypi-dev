require conf/distro/include/repo-details.inc

include conf/include/rdke-vendor-bbmask.inc
include conf/include/vendor_pkg_versions.inc

#Enable esdk
DISTRO_FEATURES_append = " VENDOR"
DISTRO_FEATURES_append = " enable_esdk"

VENDOR_LAYER_EXTENSION = "${MACHINE}-vendor"
PACKAGE_EXTRA_ARCHS_append = " ${VENDOR_LAYER_EXTENSION}"

# Override introduced to mark components or features to be moved into OSS layer.
OVERRIDES .= ":rdkv-oss"
