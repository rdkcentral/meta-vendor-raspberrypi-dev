SUMMARY = "GPU layer hardlinks and configuration"
DESCRIPTION = "Hard link graphics libraries and install GPU JSON config"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI += "file://config.json"

inherit pkgconfig

DEPENDS += "\
    westeros-soc-drm \
    mesa \
    expat \
    libdrm \
    wayland \
    wayland-default-egl \
    westeros-simpleshell \
    libffi \
    "

do_install() {
    # Destination directories
    GPU_LAYER_LIBDIR="${D}/usr/share/gpu-layer/rootfs/usr/lib"
    JSON_DIR="${D}/usr/share/gpu-layer"

    # Create directories
    install -d ${GPU_LAYER_LIBDIR}

    # ---- Hard link Graphics libraries ----
    for lib in \
        ${STAGING_LIBDIR}/libwesteros_gl.so.* \
        ${STAGING_LIBDIR}/libEGL.so.* \
        ${STAGING_LIBDIR}/libGLESv2.so.* \
        ${STAGING_LIBDIR}/libglapi.so.* \
        ${STAGING_LIBDIR}/libgbm.so.* \
        ${STAGING_LIBDIR}/libexpat.so.* \
        ${STAGING_LIBDIR}/libdrm.so.* \
        ${STAGING_LIBDIR}/libwayland-client.so.* \
        ${STAGING_LIBDIR}/libwayland-server.so.* \
        ${STAGING_LIBDIR}/libwayland-egl.so.* \
        ${STAGING_LIBDIR}/libwesteros_simpleshell_client.so.* \
        ${STAGING_LIBDIR}/libffi.so.* \
    ; do
        [ -f "$lib" ] || continue
        ln -f "$lib" "${GPU_LAYER_LIBDIR}/$(basename $lib)"
    done

    # ---- Install JSON file ----
    install -m 0644 ${WORKDIR}/config.json ${JSON_DIR}/config.json
}

# Package contents
FILES:${PN} += "\
    /usr/share/gpu-layer/rootfs/usr/lib/* \
    /usr/share/gpu-layer/gpu-config.json \
    "
PRIVATE_LIBS:${PN} = "\
    libwesteros_gl.so.0 \
    libexpat.so.1 \
    libdrm.so.2 \
    libgbm.so.1 \
    libglapi.so.0 \
    libEGL.so.1 \
    libGLESv2.so.2 \
    libwayland-egl.so.1 \
    libwayland-server.so.0 \
    libwayland-client.so.0 \
    libwesteros_simpleshell_client.so.0 \
    libffi.so.8 \
    "

INSANE_SKIP:${PN} += "already-stripped"
