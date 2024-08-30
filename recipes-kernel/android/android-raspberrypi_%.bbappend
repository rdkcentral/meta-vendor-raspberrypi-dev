FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append:hybrid = " file://rdkv.cfg"
SRC_URI:append:client = " file://rdkv.cfg"
SRC_URI:append:ipclient = " file://rdkv.cfg"

