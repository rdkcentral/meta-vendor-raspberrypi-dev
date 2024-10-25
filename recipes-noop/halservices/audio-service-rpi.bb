SUMMARY = "No Operation Recipe for audioserver"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${MANIFEST_PATH_PLATFORM}/LICENSE;md5=5bfad6e034e497ee148eec56e175c6e8"

PROVIDES = "virtual/audio-service virtual/vendor-audio-service"
RPROVIDES:${PN} = "virtual/audio-service virtual/vendor-audio-service"

ALLOW_EMPTY:${PN} = "1"

do_configure[noexec] = "1"
do_compile[noexec] = "1"
do_install[noexec] = "1"

FILES:${PN} = ""
