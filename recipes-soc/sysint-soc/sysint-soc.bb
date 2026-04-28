SUMMARY = "Sysint application - Vendor"
SECTION = "console/utils"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b1e01b26bacfc2232046c90a330332b3"

SRC_URI = "${CMF_GITHUB_ROOT}/rdkvhal-sysint-raspberrypi4;${CMF_GIT_SRC_URI_SUFFIX}"

S = "${WORKDIR}/git"

inherit systemd

RDEPENDS:${PN} += "util-linux-uuidgen"

do_compile[noexec] = "1"

SYSTEMD_AUTO_ENABLE:${PN} = "enable"

# Overlay build-configuration values from the product layer where property keys match.
update_device_properties() {
    # Escape characters special to sed replacement text (\, &, and the | delimiter).
    escape_sed_replacement() { printf '%s' "$1" | sed 's/[&|\\]/\\&/g'; }

    # Update a single key=value line in the properties file.
    replace_prop() {
        prop_key="$1"
        prop_value="$2"
        [ -n "$prop_value" ] || return 0
        escaped_value="$(escape_sed_replacement "$prop_value")"
        sed -i "s|^${prop_key}=.*|${prop_key}=$escaped_value|" "$props"
    }

    props="${D}${sysconfdir}/device-vendor.properties"

    # Normalize line endings (CRLF -> LF) and ensure a trailing newline.
    sed -i 's/\r$//' "$props"
    [ -n "$(tail -c1 "$props")" ] && echo >> "$props"

    # Replace the matching ones; BitBake expands ${VAR} at parse time before the shell runs.
    replace_prop MODEL_NUM "${DEVICE_MODEL_NUMBER}"
    replace_prop DAC_APP_PATH "${DAC_APP_PATH}"
    replace_prop APP_PREINSTALL_DIRECTORY "${APP_PREINSTALL_DIRECTORY}"
    replace_prop APP_DOWNLOAD_DIRECTORY "${APP_DOWNLOAD_DIRECTORY}"
    replace_prop DEFAULT_APP_STORAGE_PATH "${DEFAULT_APP_STORAGE_PATH}"
}

do_install() {
        install -d ${D}${systemd_unitdir}/system

        # RDKE-122: WPEFramework drop-in
        install -D -m 0644 ${S}/systemd_units/00-wpeframework-vendor.conf ${D}${systemd_unitdir}/system/wpeframework.service.d/00-wpeframework-vendor.conf
        # RDKVREFPLT-4428: temporary fix
        install -d ${D}${bindir}
        install -D -m 0644 ${S}/systemd_units/oem-first-boot.service ${D}${systemd_unitdir}/system/oem-first-boot.service
        install -D -m 0755 ${S}/scripts/oem-first-boot.sh ${D}${bindir}/oem-first-boot.sh
        install -D -m 0644 ${S}/systemd_units/enable-transition-markers.service ${D}${systemd_unitdir}/system/enable-transition-markers.service
        install -D -m 0755 ${S}/scripts/enable-transition-markers.sh ${D}${bindir}/enable-transition-markers.sh
        install -D -m 0644 ${S}/systemd_units/nvram.service ${D}${systemd_unitdir}/system/nvram.service
        install -D -m 0755 ${S}/scripts/rpiBTReset.sh ${D}${bindir}/rpiBTReset.sh
        install -D -m 0644 ${S}/systemd_units/rpiBTReset.service ${D}${systemd_unitdir}/system/rpiBTReset.service

        # RDKE-115: Dropbear drop-in conf for RPi
        install -D -m 0644 ${S}/systemd_units/00-dropbear-vendor.conf ${D}${systemd_unitdir}/system/dropbear.service.d/00-dropbear.conf
        # TODO: remove when middleware iptables_init script gets refactored. See RDKE-469.
        install -D -m 0644 ${S}/systemd_units/00-remove-static-ssh-drop-config.conf ${D}${systemd_unitdir}/system/iptables.service.d/00-remove-static-ssh-drop-config.conf

        # Dropbear SSH banner
        install -d ${D}${sysconfdir}
        install -m 0644 ${S}/dropbear/sshbanner.txt ${D}${sysconfdir}

        # Provide the OEM/SoC device.properties
        install -m 0644 ${S}/etc/device-vendor.properties ${D}${sysconfdir}
        # Update the properties to match with the build configuration.
        update_device_properties

        # Default RCU ctrlm_config.json configuration file.
        install -d ${D}${sysconfdir}/vendor/input
        install -D -m 0644 ${S}/etc/rdk-bt-rcu-config.json ${D}${sysconfdir}/vendor/input/ctrlm_config.json

        # Device-specific reset script for Factory/Warehouse reset
        install -D -m 0755 ${S}/scripts/device-specific-reset.sh ${D}/lib/rdk/device-specific-reset.sh
}

FILES:${PN} += "${systemd_unitdir}/system/*"
FILES:${PN} += "${sysconfdir}/*"
FILES:${PN} += "/lib/rdk/device-specific-reset.sh"

# RDKVREFPLT-4428: temporary fix
SYSTEMD_SERVICE:${PN} += "oem-first-boot.service"
SYSTEMD_SERVICE:${PN} += "nvram.service"
SYSTEMD_SERVICE:${PN} += "rpiBTReset.service"
SYSTEMD_SERVICE:${PN} += "enable-transition-markers.service"
