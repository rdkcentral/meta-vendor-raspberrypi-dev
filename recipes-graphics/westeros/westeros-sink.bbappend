S = "${WORKDIR}/git"

PROVIDES = "virtual/vendor-westeros-sink"
RPROVIDES:${PN} = "virtual/vendor-westeros-sink"

SINK_SOC_PATH = "${@bb.utils.contains('MACHINE_FEATURES', 'vc4graphics', 'v4l2', 'rpi', d)}"

AUTOTOOLS_SCRIPT_PATH = "${S}/${SINK_SOC_PATH}/westeros-sink"

LICENSE_LOCATION = "${S}/LICENSE"

CFLAGS:append = " ${@bb.utils.contains('MACHINE_FEATURES', 'vc4graphics', \
                    '-DWESTEROS_PLATFORM_DRM', \
                    ' -DWESTEROS_PLATFORM_RPI -DWESTEROS_INVERTED_Y -DBUILD_WAYLAND \
                    -I${STAGING_INCDIR}/interface/vmcs_host/linux', d)} -x c++"

CFLAGS:append = " -DWESTEROS_PLATFORM_DRM -x c++"

PACKAGECONFIG[gst1] = "--enable-gstreamer1=yes,--enable-gstreamer1=no,gstreamer1.0"

PACKAGECONFIG = "gst1"

do_configure:prepend() {
  ln -sf ../../westeros-sink/westeros-sink.c ${AUTOTOOLS_SCRIPT_PATH}
  ln -sf ../../westeros-sink/westeros-sink.h ${AUTOTOOLS_SCRIPT_PATH}

  sed -i -e 's/-lwesteros_simplebuffer_client/-lwesteros_compositor -lwesteros_simplebuffer_client/g' ${AUTOTOOLS_SCRIPT_PATH}/Makefile.am
  ln -sf ../../westeros-sink/westeros-sink.c ${AUTOTOOLS_SCRIPT_PATH}
  ln -sf ../../westeros-sink/westeros-sink.h ${AUTOTOOLS_SCRIPT_PATH}
}

FILES:${PN} += "${libdir}/gstreamer-*/*.so"
FILES:${PN}-dev += "${libdir}/gstreamer-*/*.la"
FILES:${PN}-dbg += "${libdir}/gstreamer-*/.debug/*"
FILES:${PN}-staticdev += "${libdir}/gstreamer-*/*.a "
