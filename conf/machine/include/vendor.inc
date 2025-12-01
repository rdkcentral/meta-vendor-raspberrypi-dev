require conf/distro/include/repo-details.inc

include conf/include/rdke-vendor-bbmask.inc
include conf/include/vendor_pkg_versions.inc

#Enable esdk
DISTRO_FEATURES:append = " VENDOR"
DISTRO_FEATURES:append = " enable_esdk"

LAYER_EXTENSION = "-vendor"
VENDOR_LAYER_EXTENSION = "${MACHINE}-vendor"
PACKAGE_EXTRA_ARCHS:append = " ${VENDOR_LAYER_EXTENSION}"

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

## RPi specific boot-config overrides for RDKV Stack.
# To enable serial console
ENABLE_UART = "1"

# Upstream meta-raspberrypi kirkstone branch has "vc4-kms-v3d". Ref RDKVREFPLT-1977
VC4DTBO = "vc4-fkms-v3d"

# Enable CPU boost for performance, ref: https://meta-raspberrypi.readthedocs.io/en/latest/extra-build-config.html
RPI_EXTRA_CONFIG += "\narm_boost=1\nhdmi_force_hotplug:0=1\nhdmi_force_hotplug:1=0\n"
