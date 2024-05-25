#From meta-rdk-oss-reference
BBMASK += " meta-rdk-oss-reference/recipes-support/cryptsetup/cryptsetup_1.7.2.bbappend"
BBMASK += " meta-rdk-oss-reference/recipes-support/lvm2/lvm2_2.02.138.bbappend"
BBMASK += " meta-rdk-oss-reference/recipes-mac/Apparmor/apparmor_%.bbappend"
#See RDK-49475 in Comcast jira. Remove when fixed from OSS layer.
BBMASK += " meta-rdk-oss-reference/recipes-graphics/wayland/wayland_%.bbappend"

#From meta-openembedded
BBMASK += " meta-openembedded/meta-multimedia/recipes-multimedia/tinyalsa/tinyalsa.bb"
BBMASK += " meta-openembedded/meta-oe/recipes-devtools/breakpad/breakpad_svn.bb"

#From meta-rdk-halif-headers
# FIXME: unmask as integration progresses
BBMASK += " meta-rdk-halif-headers/recipes-rdk-halif-headers/audiocapture/"
BBMASK += " meta-rdk-halif-headers/recipes-rdk-halif-headers/hdmicec"
BBMASK += " meta-rdk-halif-headers/recipes-rdk-halif-headers/tvsettings"

