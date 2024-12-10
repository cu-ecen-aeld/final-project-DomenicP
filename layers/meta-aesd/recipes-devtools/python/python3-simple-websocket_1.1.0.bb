SUMMARY = "Simple WebSocket server and client for Python"
HOMEPAGE = "https://github.com/miguelgrinberg/simple-websocket"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9d272c9fe2437531b5bbecf4fcc82e24"

SRC_URI[sha256sum] = "7939234e7aa067c534abdab3a9ed933ec9ce4691b0713c78acb195560aa52ae4"

SRC_URI += "file://setup.cfg;subdir=simple_websocket-${PV}"

PYPI_ARCHIVE_NAME = "simple_websocket-${PV}.tar.gz"

inherit pypi python_setuptools_build_meta

S = "${WORKDIR}/simple_websocket-${PV}"

RDEPENDS:${PN} = "${PYTHON_PN}-wsproto"
