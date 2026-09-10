do_compile:append() {
    if ${@bb.utils.contains('DISTRO_FEATURES', 'DOBBY_CONTAINERS', 'true', 'false', d)}; then

        CMDLINE_FILE="${WORKDIR}/cmdline.txt"
        sed -i 's/[[:space:]]*$//' ${CMDLINE_FILE}

        # Append only if not already present
        for param in \
            "cgroup_enable=memory" \
            "cgroup_memory=1" \
            "systemd.unified_cgroup_hierarchy=1"
        do
            grep -qw "${param}" ${CMDLINE_FILE} || \
                sed -i "s/$/ ${param}/" ${CMDLINE_FILE}
        done

    fi
}
