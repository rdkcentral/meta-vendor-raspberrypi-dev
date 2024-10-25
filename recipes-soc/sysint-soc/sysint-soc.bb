SUMMARY = "Sysint application - Vendor"
SECTION = "console/utils"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b1e01b26bacfc2232046c90a330332b3"
 
SRC_URI = "${CMF_GITHUB_ROOT}/rdkvhal-sysint-raspberrypi4;${CMF_GIT_SRC_URI_SUFFIX}"

S = "${WORKDIR}/git"

do_compile[noexec] = "1"

do_install() {
        install -d ${D}${systemd_unitdir}/system
        # RDKE-122: WPEFramework drop-in
        install -D -m 0644 ${S}/systemd_units/00-wpeframework-vendor.conf ${D}${systemd_unitdir}/system/wpeframework.service.d/00-wpeframework-vendor.conf

        # RDKE-115: Dropbear drop-in conf for RPi
        install -D -m 0644 ${S}/systemd_units/00-dropbear-vendor.conf ${D}${systemd_unitdir}/system/dropbear.service.d/00-dropbear.conf

        # Dropbear SSH banner
        install -d ${D}${sysconfdir}
        install -m 0644 ${S}/dropbear/sshbanner.txt ${D}${sysconfdir}

        # Provide the OEM/SoC device.properties
        install -m 0644 ${S}/etc/device-vendor.properties ${D}${sysconfdir}
}

FILES:${PN} += "${systemd_unitdir}/system/*"
FILES:${PN} += "${sysconfdir}/*"
