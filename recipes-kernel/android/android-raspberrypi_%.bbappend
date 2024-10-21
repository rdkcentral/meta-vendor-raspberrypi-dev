FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append_hybrid = " file://rdkv.cfg"
SRC_URI_append_client = " file://rdkv.cfg"
SRC_URI_append_ipclient = " file://rdkv.cfg"

# Fix for annoying HCI logs in console; only need to be patched in dunfell. Kirkstone already has this.
SRC_URI_append_dunfell = " file://Bluetooth-refactor-malicious-adv-data-check.patch"

do_deploy_append() {
   if [ "${@bb.utils.contains("DISTRO_FEATURES", "DOBBY_CONTAINERS", "yes", "no", d)}" = "yes" ]; then
        if [ -f "${DEPLOYDIR}/bootfiles/cmdline.txt" ]; then
            sed -i 's/[[:space:]]*$//g' ${DEPLOYDIR}/bootfiles/cmdline.txt
            sed -i 's/$/ cgroup_enable=memory cgroup_memory=1/' ${DEPLOYDIR}/bootfiles/cmdline.txt
        fi
   fi
}
