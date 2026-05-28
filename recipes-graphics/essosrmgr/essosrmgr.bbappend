CXXFLAGS:append = "${@bb.utils.contains('DISTRO_FEATURES', 'use_westeros_essrmgr_uds', ' -DUSE_ESSRMGR_UDS_IMPL', '', d)}"
CXXFLAGS:append = "${@bb.utils.contains('DISTRO_FEATURES', 'upstream_wayland_egl', ' -DUSE_ESS_BRCM_UPSTREAM_WAYLAND', '', d)}"
#RDEPENDS:${PN} += "${@bb.utils.contains('DISTRO_FEATURES','upstream_wayland_egl','','westeros-render-nexus',d)}"
RDEPENDS:${PN} += "${@bb.utils.contains('DISTRO_FEATURES','upstream_wayland_egl','','westeros-soc',d)}"
