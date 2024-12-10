SUMMARY = "Embedded camera server node"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://pipeline.sh file://camera-server.service"

S = "${WORKDIR}"

inherit systemd

SYSTEMD_SERVICE:${PN} = "camera-server.service"

do_install() {
    install -d "${D}${libexecdir}/camera-server"
    install -m 755 "${S}/pipeline.sh" "${D}${libexecdir}/camera-server/"

    install -d "${D}${systemd_system_unitdir}"
    install -m 644 "${S}/camera-server.service" "${D}${systemd_system_unitdir}/"
    sed -i -e "s,@LIBEXECDIR@,${libexecdir},g" "${D}${systemd_system_unitdir}/camera-server.service"
}

FILES:${PN} += "${libexecdir}/camera-server"

RDEPENDS:${PN} = "gstreamer1.0 \
                  gstreamer1.0-plugins-bad \
                  gstreamer1.0-plugins-base \
                  gstreamer1.0-plugins-good \
                  gstreamer1.0-plugins-tegra \
                  gstreamer1.0-plugins-ugly \
                  gstreamer1.0-rtsp-server \
                  mediamtx \
                  "
