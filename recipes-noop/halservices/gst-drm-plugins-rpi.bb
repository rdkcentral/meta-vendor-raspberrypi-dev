SUMMARY = "No Operation Recipe for gstreamer drm plugins"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${MANIFEST_PATH_PLATFORM}/LICENSE;md5=5bfad6e034e497ee148eec56e175c6e8"

PROVIDES = "virtual/gst-drm-plugins virtual/vendor-gst-drm-plugins"
RPROVIDES:${PN} = "virtual/gst-drm-plugins virtual/vendor-gst-drm-plugins"

ALLOW_EMPTY:${PN} = "1"

do_configure[noexec] = "1"
do_compile[noexec] = "1"
do_install[noexec] = "1"

FILES:${PN} = ""
