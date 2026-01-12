require conf/distro/include/repo-details.inc

include conf/include/rdke-vendor-bbmask.inc
include conf/include/vendor_pkg_versions.inc

#Enable esdk
DISTRO_FEATURES:append = " VENDOR"
DISTRO_FEATURES:append = " enable_esdk"

VENDOR_LAYER_EXTENSION = "${MACHINE}-vendor"
PACKAGE_EXTRA_ARCHS:append = " ${VENDOR_LAYER_EXTENSION}"

LAYER_EXTENSION = "-vendor"
VENDOR_OSS_REL_VER = "4.10.0"
VENDOR_OSS = "${@get_oss_arch(d)}${LAYER_EXTENSION}"
PACKAGE_EXTRA_ARCHS:append = "${@ '' if '${VENDOR_OSS}' == '${OSS_LAYER_ARCH}' else ' ${VENDOR_OSS}'}"
OPKG_ARCH_PRIORITY:${VENDOR_OSS} = "310"
STACK_LAYER_EXTENSION ?= "${VENDOR_OSS} ${VENDOR_LAYER_EXTENSION}"
EXCLUDE_IPK_FEEDS ?= "${VENDOR_OSS} ${VENDOR_LAYER_EXTENSION}"

LICENSE_FLAGS_ACCEPTED += "commercial_gst-fluendo-mpegdemux \
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

#Android raspberrypi Kernel version
KERNEL_ARPI_MAJOR_VERSION = "6"
