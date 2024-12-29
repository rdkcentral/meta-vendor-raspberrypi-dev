SUMMARY = "Network Setup Service"
DESCRIPTION = "A service to bring up a network interface and acquire an IP address using udhcpc."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://network_setup.sh \
           file://network_setup.service"

S = "${WORKDIR}"

inherit systemd

RDEPENDS:${PN} = " bash "

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "network_setup.service"

do_compile[noexec] = "1"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/network_setup.sh ${D}${bindir}/network_setup.sh

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/network_setup.service ${D}${systemd_system_unitdir}/network_setup.service
}

FILES:${PN} += "${systemd_unitdir}/system/*"
FILES:${PN} += "${bindir}"
