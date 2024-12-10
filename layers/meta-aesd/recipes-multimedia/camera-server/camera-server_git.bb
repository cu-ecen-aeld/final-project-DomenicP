SUMMARY = "Embedded camera server node"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=423f6e69f9d204e27405e8b6e35eb83f"

SRC_URI = "git://github.com/DomenicP/final-project-assignment-DomenicP.git;protocol=https;branch=main \
           file://camera-server.service \
           "

PV = "0.1.0+git${SRCPV}"
SRCREV = "35b4560e8900ae74b39589ceef9595378f731448"

S = "${WORKDIR}/git/camera-server"

inherit python_flit_core systemd

SYSTEMD_SERVICE:${PN} = "camera-server.service"

do_install:append() {
    install -d "${D}${systemd_system_unitdir}"
    install -m 644 "${WORKDIR}/camera-server.service" "${D}${systemd_system_unitdir}/"
}

RDEPENDS:${PN} = "gstreamer1.0 \
                  gstreamer1.0-plugins-bad \
                  gstreamer1.0-plugins-base \
                  gstreamer1.0-plugins-good \
                  gstreamer1.0-plugins-tegra \
                  gstreamer1.0-plugins-ugly \
                  gstreamer1.0-rtsp-server \
                  mediamtx \
                  python3-pyzmq \
                  "
