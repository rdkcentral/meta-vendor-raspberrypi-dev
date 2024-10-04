SUMMARY = "No Operation Recipe for gstreamer drm plugins"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5bfad6e034e497ee148eec56e175c6e8"
SRC_URI = "file://LICENSE"

PROVIDES = "virtual/gst-drm-plugins virtual/vendor-gst-drm-plugins"
RPROVIDES:${PN} = "virtual/gst-drm-plugins virtual/vendor-gst-drm-plugins"
ALLOW_EMPTY:${PN} = "1"

PACKAGE_ARCH = "${VENDOR_LAYER_EXTENSION}"
S = "${WORKDIR}"

do_configure() {
    : # Do nothing
}

do_compile() {
    : # Do nothing
}

do_install() {
    : # Do nothing
}

FILES_${PN} = ""
