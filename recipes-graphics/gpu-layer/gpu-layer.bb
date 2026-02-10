SUMMARY = "GPU layer libraries and configuration"
DESCRIPTION = "Install GPU shared libraries into gpu-layer rootfs and deploy JSON configuration"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

# GPU configuration file
SRC_URI += "file://config.json"

# Build-time providers for GPU / graphics components
DEPENDS += "\
    mesa \
    libdrm \
    wayland-default-egl \
    westeros-soc-drm \
    expat \
    "

# gpu-layer layout inside target rootfs
GPU_LAYER_LIBDIR  = "${D}/usr/share/gpu-layer/rootfs/usr/lib"
GPU_LAYER_DRIDIR  = "${GPU_LAYER_LIBDIR}/dri"
GPU_LAYER_CONFDIR = "${D}/usr/share/gpu-layer"

# Shared libraries to bundle into gpu-layer (SONAME-based)
GPU_LAYER_LIBS = "\
    libdrm.so.2 \
    libEGL.so.1 \
    libGLESv2.so.2 \
    libGLESv1_CM.so.1 \
    libgbm.so.1 \
    libglapi.so.0 \
    libexpat.so.1 \
    libwayland-egl.so.1 \
    libwesteros_gl.so.0 \
    "

# DRI drivers required by Mesa (software + VC4)
GPU_LAYER_DRI_LIBS = "\
    swrast_dri.so \
    vc4_dri.so \
    "

do_install() {
    # Create gpu-layer directory structure
    install -d \
        ${GPU_LAYER_LIBDIR} \
        ${GPU_LAYER_DRIDIR} \
        ${GPU_LAYER_CONFDIR}

    #
    # copy_and_symlink:
    #   - Copy a SONAME shared library from sysroot
    #   - Create an unversioned .so symlink
    #
    #   Example:
    #     libEGL.so.1  → copied
    #     libEGL.so    → symlink → libEGL.so.1
    #
    copy_and_symlink() {
        soname="$1"
        src="${STAGING_LIBDIR}/${soname}"

        # Skip if library is not present in sysroot
        [ -e "${src}" ] || return

        # Derive unversioned linker name (libXYZ.so)
        linkname="$(echo "${soname}" | sed 's/\.so\..*/.so/')"

        # Install the SONAME library (read-only, runtime use)
        install -m 0444 "${src}" "${GPU_LAYER_LIBDIR}/${soname}"

        # Create symlink for linker compatibility
        ln -sf "${soname}" "${GPU_LAYER_LIBDIR}/${linkname}"
    }

    # Install GPU shared libraries
    for lib in ${GPU_LAYER_LIBS}; do
        copy_and_symlink "$lib"
    done

    # Install Mesa DRI drivers
    for dri in ${GPU_LAYER_DRI_LIBS}; do
        install -m 0444 "${STAGING_LIBDIR}/dri/${dri}" "${GPU_LAYER_DRIDIR}/${dri}"
    done

    # Install GPU configuration
    install -m 0444 ${WORKDIR}/config.json ${GPU_LAYER_CONFDIR}/config.json
}

# Package contents
FILES:${PN} += "/usr/share/gpu-layer"

# Libraries intentionally bundled inside gpu-layer
# (avoid shlibs auto-dependency generation)
PRIVATE_LIBS:${PN} = "${GPU_LAYER_LIBS}"

# Skip dev-so QA check because we deliberately install unversioned .so symlinks
INSANE_SKIP:${PN} += "dev-so"
