FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append_hybrid = " file://rdkv.cfg"
SRC_URI:append:client = " file://rdkv.cfg"
SRC_URI:append_ipclient = " file://rdkv.cfg"

do_deploy:append() {
   if [ "${@bb.utils.contains("DISTRO_FEATURES", "DOBBY_CONTAINERS", "yes", "no", d)}" = "yes" ]; then
        if [ -f "${DEPLOYDIR}/bootfiles/cmdline.txt" ]; then
            sed -i 's/[[:space:]]*$//g' ${DEPLOYDIR}/bootfiles/cmdline.txt
            sed -i 's/$/ cgroup_enable=memory cgroup_memory=1/' ${DEPLOYDIR}/bootfiles/cmdline.txt
        fi
   fi
}
