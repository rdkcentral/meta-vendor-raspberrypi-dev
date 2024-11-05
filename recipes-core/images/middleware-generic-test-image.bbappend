ROOTFS_POSTPROCESS_COMMAND_remove = " rpi_generate_sysctl_config ; "
ROOTFS_POSTPROCESS_COMMAND += " rpi_generate_systemd_config ; "

rpi_generate_systemd_config() {
    if [ "${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}" = "true" ]
    then
         # systemd sysctl config
         test -d ${IMAGE_ROOTFS}${sysconfdir}/sysctl.d && \
             echo "vm.min_free_kbytes = 8192" > ${IMAGE_ROOTFS}${sysconfdir}/sysctl.d/rpi-vm.conf
    else
         # sysv sysctl config
         IMAGE_SYSCTL_CONF="${IMAGE_ROOTFS}${sysconfdir}/sysctl.conf"
         test -e ${IMAGE_ROOTFS}${sysconfdir}/sysctl.conf && \
             sed -e "/vm.min_free_kbytes/d" -i ${IMAGE_SYSCTL_CONF}
         echo "" >> ${IMAGE_SYSCTL_CONF} && echo "vm.min_free_kbytes = 8192" >> ${IMAGE_SYSCTL_CONF}
    fi
}
