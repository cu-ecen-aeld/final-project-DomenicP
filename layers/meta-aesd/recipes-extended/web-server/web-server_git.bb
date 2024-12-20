SUMMARY = "Simple web server for camera streaming demo."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=423f6e69f9d204e27405e8b6e35eb83f"

SRC_URI = "git://github.com/DomenicP/final-project-assignment-DomenicP.git;protocol=https;branch=main \
           file://web-server.service \
           "

PV = "0.1.0+git${SRCPV}"
SRCREV = "35b4560e8900ae74b39589ceef9595378f731448"

S = "${WORKDIR}/git/web-server"

inherit python_flit_core systemd

SYSTEMD_SERVICE:${PN} = "web-server.service"

do_install:append() {
    install -d "${D}${systemd_system_unitdir}"
    install -m 644 "${WORKDIR}/web-server.service" "${D}${systemd_system_unitdir}/"
}

RDEPENDS:${PN} = "python3-flask \
                  python3-flask-sock \
                  python3-gunicorn \
                  python3-pyzmq \
                  "
