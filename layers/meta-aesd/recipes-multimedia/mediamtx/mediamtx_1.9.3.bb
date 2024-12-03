SUMMARY = "Ready-to-user media server and media proxy."
DESCRIPTION = "Ready-to-use SRT / WebRTC / RTSP / RTMP / LL-HLS media server and media \
               proxy that allows to read, publish, proxy, record and playback video \
               and audio streams."

HOMEPAGE = "https://github.com/bluenviron/mediamtx"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=77fd2623bd5398430be5ce60489c2e81"

COMPATIBLE_HOST = "(aarch64|arm64).*-linux"

SRC_URI = "https://github.com/bluenviron/mediamtx/releases/download/v${PV}/mediamtx_v${PV}_linux_arm64v8.tar.gz \
           file://mediamtx.service \
           "
SRC_URI[sha256sum] = "f2f02109dd3d88773d7de5ae84385d41041bc9d60d0459eb6c61462cb2da0d1e"

S = "${WORKDIR}"

inherit systemd

do_install () {
    install -d "${D}${bindir}"
    install -m 755 "${S}/mediamtx" "${D}${bindir}/"

    install -d "${D}${sysconfdir}"
    install -m 644 "${S}/mediamtx.yml" "${D}${sysconfdir}/"

    install -d "${D}${systemd_system_unitdir}"
    install -m 644 "${S}/mediamtx.service" "${D}${systemd_system_unitdir}"
}

FILES:${PN} = "${bindir}/mediamtx \
               ${sysconfdir}/mediamtx.yml \
               ${systemd_system_unitdir}/mediamtx.service \
               "
