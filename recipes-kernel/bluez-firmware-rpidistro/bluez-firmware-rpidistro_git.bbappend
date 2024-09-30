do_install_append() {
    rm -rf ${D}${nonarch_base_libdir}
    install -d ${D}${sysconfdir}/firmware/brcm

    cp LICENCE.cypress-rpidistro ${D}${sysconfdir}/firmware
    install -m 0644 broadcom/BCM434*.hcd ${D}${sysconfdir}/firmware/brcm/
}

FILES_${PN}-cypress-license = "\
    ${sysconfdir}/firmware/LICENCE.cypress-rpidistro \
"
FILES_${PN}-bcm43430a1-hcd = "\
    ${sysconfdir}/firmware/brcm/BCM43430A1.hcd \
"
FILES_${PN}-bcm4345c0-hcd = "\
    ${sysconfdir}/firmware/brcm/BCM4345C0.hcd \
"

FILES_${PN}-cypress-license_remove = "\
    ${nonarch_base_libdir}/firmware/LICENCE.cypress-rpidistro \
"
FILES_${PN}-bcm43430a1-hcd_remove = "\
    ${nonarch_base_libdir}/firmware/brcm/BCM43430A1.hcd \
"
FILES_${PN}-bcm4345c0-hcd_remove = "\
    ${nonarch_base_libdir}/firmware/brcm/BCM4345C0.hcd \
"
