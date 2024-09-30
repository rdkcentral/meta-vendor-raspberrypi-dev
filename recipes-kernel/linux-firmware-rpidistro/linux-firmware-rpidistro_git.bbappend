do_install_append() {
    rm -rf ${D}${nonarch_base_libdir}/firmware
    install -d ${D}${sysconfdir}/firmware/brcm

    cp ./LICENCE.broadcom_bcm43xx ${D}${sysconfdir}/firmware/LICENCE.broadcom_bcm43xx-rpidistro

    # Replace outdated linux-firmware files with updated ones from
    # raspbian firmware-nonfree. Raspbian adds blobs and nvram
    # definitions that are also necessary so copy those too.
    for fw in brcmfmac43430-sdio brcmfmac43455-sdio ; do
        install -m 0644 brcm/${fw}.* ${D}${sysconfdir}/firmware/brcm/
    done
    # add compat links. Fixes errors like
    # brcmfmac mmc1:0001:1: Direct firmware load for brcm/brcmfmac43455-sdio.raspberrypi,4-model-b.txt failed with error -2
    ln -s brcmfmac43455-sdio.txt ${D}${sysconfdir}/firmware/brcm/brcmfmac43455-sdio.raspberrypi,4-model-b.txt
    ln -s brcmfmac43455-sdio.txt ${D}${sysconfdir}/firmware/brcm/brcmfmac43455-sdio.raspberrypi,4-compute-module.txt
    ln -s brcmfmac43455-sdio.txt ${D}${sysconfdir}/firmware/brcm/brcmfmac43455-sdio.raspberrypi,3-model-b-plus.txt
    ln -s brcmfmac43430-sdio.txt ${D}${sysconfdir}/firmware/brcm/brcmfmac43430-sdio.raspberrypi,3-model-b.txt
}


FILES_${PN}-broadcom-license = "${sysconfdir}/firmware/LICENCE.broadcom_bcm43xx-rpidistro"
FILES_${PN}-bcm43430 = "${sysconfdir}/firmware/brcm/brcmfmac43430*"
FILES_${PN}-bcm43455 = "${sysconfdir}/firmware/brcm/brcmfmac43455*"

