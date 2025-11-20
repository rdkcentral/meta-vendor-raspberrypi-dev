PE = "1"
PV = "6.1.77"

SRCREV_machine = "c3a4809076cc88dce4113d0cae0dc6d319d54593"
SRCREV_meta    = "b22812cadd2686e2cea44e196dc0436dc7882469"

SRC_URI = " \
    git://github.com/android-rpi/kernel_arpi/;branch=arpi14-6.1;name=machine;protocol=https \
    git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-6.1;destsuffix=kernel-meta \
    file://powersave.cfg \
    file://android-drivers.cfg \
    file://disable_nnp_lsm_check.patch \
    file://video-drivers.cfg \
    file://disable-framebuffer-console.cfg \
    file://0001-RDKEVL-6480-RPI-Kernel-ACK6.1-CompilationErrorFix.patch \
    file://apparmor.cfg \
    "

# Keep file search path like your earlier bbappend did
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

# If you use machine flavor appends (same as original)
SRC_URI:append:hybrid = " file://rdkv.cfg"
SRC_URI:append:client = " file://rdkv.cfg"
SRC_URI:append:ipclient = " file://rdkv.cfg"

require android-raspberrypi.inc

# If you had explicitly disabled the version sanity check earlier, keep same behaviour:
KERNEL_VERSION_SANITY_SKIP = "1"
