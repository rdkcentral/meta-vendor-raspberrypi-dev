do_install:append() {
    rm -rf ${D}${nonarch_base_libdir}
    install -d ${D}${sysconfdir}/firmware/brcm

    cp LICENCE.cypress-rpidistro ${D}${sysconfdir}/firmware
    install -m 0644 broadcom/BCM43430A1.hcd ${D}${sysconfdir}/firmware/brcm/
    install -m 0644 broadcom/BCM4345C0.hcd ${D}${sysconfdir}/firmware/brcm/
}

FILES:${PN}-cypress-license = "\
    ${sysconfdir}/firmware/LICENCE.cypress-rpidistro \
"
FILES:${PN}-bcm43430a1-hcd = "\
    ${sysconfdir}/firmware/brcm/BCM43430A1.hcd \
"
FILES:${PN}-bcm4345c0-hcd = "\
    ${sysconfdir}/firmware/brcm/BCM4345C0.hcd \
"
