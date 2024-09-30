require conf/distro/include/repo-details.inc

include conf/include/rdke-vendor-bbmask.inc
include conf/include/vendor_pkg_versions.inc

#Enable esdk
DISTRO_FEATURES_append = " VENDOR"
DISTRO_FEATURES_append = " enable_esdk"

VENDOR_LAYER_EXTENSION = "${MACHINE}-vendor"
PACKAGE_EXTRA_ARCHS_append = " ${VENDOR_LAYER_EXTENSION}"

LICENSE_FLAGS_WHITELIST += "commercial_gst-fluendo-mpegdemux \
                            commercial_${MLPREFIX}gst-ffmpeg \
                            ${@bb.utils.contains('DISTRO_FEATURES', 'gstreamer1_18','commercial_${MLPREFIX}ffmpeg','commercial_${MLPREFIX}libav',d)} \
                            commercial_libomxil \
                            commercial_gst-openmax \
                            commercial_mpg123 \
                            commercial_${MLPREFIX}x264 \
                            commercial_gstreamer1.0-omx \
                            commercial_${MLPREFIX}gstreamer1.0-libav"

# Override introduced to mark components or features to be moved into OSS layer.
OVERRIDES .= ":rdkv-oss"
