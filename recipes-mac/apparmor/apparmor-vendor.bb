DESCRIPTION = "Apparmor profiles for vendor"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=175792518e4ac015ab6696d16c4f607e"

SRC_URI = "${CMF_GITHUB_ROOT}/rdkvhal-apparmor-raspberrypi4;${CMF_GIT_SRC_URI_SUFFIX};destsuffix=git"
SRC_URI += "${CMF_GITHUB_ROOT}/rdk-apparmor-profiles.git;${CMF_GIT_SRC_URI_SUFFIX};destsuffix=git/rdk-apparmor-profiles;name=rdk-apparmor-profiles"

S = "${WORKDIR}/git"

DEPENDS += "virtual/kernel"

do_configure[depends] += "virtual/kernel:do_shared_workdir"

python do_parse_kernel_config() {
    import os
    kernel_config = d.getVar('STAGING_KERNEL_BUILDDIR', True)
    with open(os.path.join(kernel_config, '.config'), 'r') as config_file:
        config_contents = config_file.read()
        if 'CONFIG_SECURITY_APPARMOR=y' not in config_contents or 'CONFIG_SECURITY=y' not in config_contents:
            raise SystemExit("Apparmor is not enabled in kernel configuration, aborting build")
}

addtask do_parse_kernel_config after do_configure before do_compile

do_install(){
    install -d ${D}${sysconfdir}/apparmor
    install -d ${D}${sysconfdir}/apparmor/caps/
    install -d ${D}${sysconfdir}/apparmor.d
    install -d ${D}${sysconfdir}/apparmor.d/vendor/
    install -d ${D}${systemd_unitdir}/system

    install -D -m 0644 ${S}/apparmor-vendor.conf ${D}${systemd_unitdir}/system/apparmor.service.d/apparmor-vendor.conf
    install -m -0644 ${S}/platform_profiles/* ${D}${sysconfdir}/apparmor.d/vendor/
    
    if [ -f "${S}/apparmor_platform_defaults" ]; then
          install -m 0644 ${S}/apparmor_platform_defaults ${D}${sysconfdir}/apparmor/apparmor_defaults
    else
          install -m 0644 ${S}/rdk-apparmor-profiles/apparmor_generic_profile  ${D}${sysconfdir}/apparmor/apparmor_defaults
    fi

    install -m 0644 ${S}/rdk-apparmor-profiles/generic_profiles/* ${D}${sysconfdir}/apparmor.d/
    install -m 0644 ${S}/rdk-apparmor-profiles/default  ${D}${sysconfdir}/apparmor/caps/default
}

FILES:${PN} = "${sysconfdir}/apparmor/* ${sysconfdir}/apparmor.d/* "
FILES:${PN} += " ${systemd_unitdir}/system/*"
