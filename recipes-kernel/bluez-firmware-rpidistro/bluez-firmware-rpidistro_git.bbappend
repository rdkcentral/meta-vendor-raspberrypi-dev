do_install:append() {
    install -d ${D}${sysconfdir}/firmware/brcm

    ln -s ${nonarch_base_libdir}/firmware/LICENCE.cypress-rpidistro ${D}${sysconfdir}/firmware/LICENCE.cypress-rpidistro
    ln -s ${nonarch_base_libdir}/firmware/brcm/BCM43430A1.hcd ${D}${sysconfdir}/firmware/brcm/BCM43430A1.hcd
    ln -s ${nonarch_base_libdir}/firmware/brcm/BCM4345C0.hcd ${D}${sysconfdir}/firmware/brcm/BCM4345C0.hcd
}

FILES:${PN}-cypress-license += "\
    ${sysconfdir}/firmware/LICENCE.cypress-rpidistro \
"
FILES:${PN}-bcm43430a1-hcd += "\
    ${sysconfdir}/firmware/brcm/BCM43430A1.hcd \
"
FILES:${PN}-bcm4345c0-hcd += "\
    ${sysconfdir}/firmware/brcm/BCM4345C0.hcd \
"
