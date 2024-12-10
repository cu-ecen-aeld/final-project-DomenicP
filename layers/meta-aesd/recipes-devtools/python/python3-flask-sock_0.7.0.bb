SUMMARY = "WebSocket support for Flask"
DESCRIPTION = "WebSocket support for Flask. What makes this extension different than \
               others is that it does not require a greenlet based server (gevent, \
               eventlet) to work."
HOMEPAGE = "https://github.com/miguelgrinberg/flask-sock"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9d272c9fe2437531b5bbecf4fcc82e24"

SRC_URI[sha256sum] = "e023b578284195a443b8d8bdb4469e6a6acf694b89aeb51315b1a34fcf427b7d"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} = "${PYTHON_PN}-flask \
                  ${PYTHON_PN}-simple-websocket \
                  "
