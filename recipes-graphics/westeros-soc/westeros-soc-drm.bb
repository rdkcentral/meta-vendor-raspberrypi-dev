require recipes-graphics/westeros/westeros.inc

SUMMARY = "This receipe compiles the westeros gl component for drm supported platforms, currently the HiKey board"
LICENSE_LOCATION = "${S}/../LICENSE"

S = "${WORKDIR}/git/drm"

COMPATIBLE_MACHINE = "(hikey-32|dragonboard-410c-32|dragonboard-820c-32|poplar|imx8mqevk)"

DEPENDS = "wayland virtual/egl glib-2.0 libdrm"

PROVIDES = "virtual/westeros-soc westeros-soc"
RPROVIDES_${PN} = "virtual/westeros-soc westeros-soc"

CFLAGS_append = " -I${STAGING_INCDIR}/libdrm"

SECURITY_CFLAGS_remove = "-fpie"
SECURITY_CFLAGS_remove = "-pie"

DEBIAN_NOAUTONAME_${PN} = "1"
DEBIAN_NOAUTONAME_${PN}-dbg = "1"
DEBIAN_NOAUTONAME_${PN}-dev = "1"
DEBIAN_NOAUTONAME_${PN}-staticdev = "1"

inherit autotools pkgconfig

#Commented below line to get "westeros-gl-console" binary into final image.
#FILES_${PN} = "${libdir}/*"

COMPATIBLE_MACHINE = "${@bb.utils.contains('MACHINE_FEATURES', 'vc4graphics', '(.*)', 'null', d)}"

# incase if enabled in bb file, it should be removed for Rpi
CFLAGS_remove = "${@bb.utils.contains('MACHINE_FEATURES', 'vc4graphics', '-DWESTEROS_GL_NO_PLANES', '', d)}"
CFLAGS_append = "${@bb.utils.contains('MACHINE_FEATURES', 'vc4graphics', ' -DDRM_NO_NATIVE_FENCE', '', d)}"

