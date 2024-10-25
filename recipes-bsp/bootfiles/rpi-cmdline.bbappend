do_compile:append() {
   if ${@bb.utils.contains('DISTRO_FEATURES', 'DOBBY_CONTAINERS', 'true', 'false', d)}; then
        sed -i 's/[[:space:]]*$//g' ${WORKDIR}/cmdline.txt
        sed -i 's/$/ cgroup_enable=memory cgroup_memory=1/' ${WORKDIR}/cmdline.txt
   fi
}
