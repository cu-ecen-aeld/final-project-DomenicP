FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://static-ip.network"

PACKAGECONFIG = ""

do_install() {
    install -D -m 0644 "${WORKDIR}/static-ip.network" "${D}${systemd_unitdir}/network/80-wired.network"
}
