
PE = "1"
PV = "5.15.92"

SRCREV_machine = "52cc0a3d8bdee74262c0e326d59bc844d511bfa5"
#SRCREV_meta="567f0adb9d6462279d2e024153d0a8c3a3ff0551"
SRCREV_meta="5d52d9eea95fa09d404053360c2351b2b91b323b"

SRC_URI = " \
            git://github.com/android-rpi/kernel_arpi/;branch=arpi-5.15;name=machine;protocol=https \
            git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-5.10;destsuffix=kernel-meta \
            file://powersave.cfg \
            file://android-drivers.cfg \
            file://disable_nnp_lsm_check.patch \
            "

##### bbappended from meta-cmf-raspberrypi #####
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append:hybrid = " file://rdkv.cfg"
SRC_URI:append:client = " file://rdkv.cfg"
SRC_URI:append:ipclient = " file://rdkv.cfg"

require android-raspberrypi.inc

KERNEL_VERSION_SANITY_SKIP="1"