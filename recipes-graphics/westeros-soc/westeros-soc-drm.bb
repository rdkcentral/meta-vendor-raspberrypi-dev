require recipes-graphics/westeros/westeros.inc

SUMMARY = "This receipe compiles the westeros gl component for drm supported platforms, currently the HiKey board"
LICENSE_LOCATION = "${S}/../LICENSE"

S = "${WORKDIR}/git/drm"

COMPATIBLE_MACHINE = "(hikey-32|dragonboard-410c-32|dragonboard-820c-32|poplar|imx8mqevk)"

DEPENDS = "wayland virtual/egl glib-2.0 libdrm"

PROVIDES = " \
    virtual/westeros-soc \
    virtual/vendor-westeros-soc \
    westeros-soc \
    "
RPROVIDES:${PN} = " \
    virtual/westeros-soc \
    virtual/vendor-westeros-soc \
    westeros-soc \
    "

CFLAGS:append = " -I${STAGING_INCDIR}/libdrm"

SECURITY_CFLAGS:remove = "-fpie"
SECURITY_CFLAGS:remove = "-pie"

DEBIAN_NOAUTONAME:${PN} = "1"
DEBIAN_NOAUTONAME:${PN}-dbg = "1"
DEBIAN_NOAUTONAME:${PN}-dev = "1"
DEBIAN_NOAUTONAME:${PN}-staticdev = "1"

inherit autotools pkgconfig

#Commented below line to get "westeros-gl-console" binary into final image.
#FILES:${PN} = "${libdir}/*"

COMPATIBLE_MACHINE = "${@bb.utils.contains('MACHINE_FEATURES', 'vc4graphics', '(.*)', 'null', d)}"

# incase if enabled in bb file, it should be removed for Rpi
CFLAGS:remove = "${@bb.utils.contains('MACHINE_FEATURES', 'vc4graphics', '-DWESTEROS_GL_NO_PLANES', '', d)}"
CFLAGS:append = "${@bb.utils.contains('MACHINE_FEATURES', 'vc4graphics', ' -DDRM_NO_NATIVE_FENCE', '', d)}"

