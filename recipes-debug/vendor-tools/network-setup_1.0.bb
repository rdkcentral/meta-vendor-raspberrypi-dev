SUMMARY = "Network Setup Service"
DESCRIPTION = "A service to bring up a network interface and acquire an IP address using udhcpc."
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "file://network_setup.sh \
           file://network-setup.service"

S = "${WORKDIR}"

inherit systemd

RDEPENDS:${PN} = " bash "

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "network-setup.service"

do_patch[noexec] = "1"
do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/network_setup.sh ${D}${bindir}/network_setup.sh

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/network-setup.service ${D}${systemd_system_unitdir}/network-setup.service
}

FILES:${PN} += "${systemd_unitdir}/system/*"
FILES:${PN} += "${bindir}"
