
PE = "1"
PV = "6.1"

SRCREV_machine = "c3a4809076cc88dce4113d0cae0dc6d319d54593"
SRCREV_meta="b292fbe55b1863cdb444fca24634f89b016215ed"

SRC_URI = " \
            git://github.com/android-rpi/kernel_arpi/;branch=arpi14-6.1;name=machine;protocol=https \
            git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-6.1;destsuffix=kernel-meta \
            file://powersave.cfg \
            file://android-drivers.cfg \
            file://disable_nnp_lsm_check.patch \
            file://video-drivers.cfg \
            "

##### bbappended from meta-cmf-raspberrypi #####
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append:hybrid = " file://rdkv.cfg"
SRC_URI:append:client = " file://rdkv.cfg"
SRC_URI:append:ipclient = " file://rdkv.cfg"

require android-raspberrypi.inc

KERNEL_VERSION_SANITY_SKIP="1"
