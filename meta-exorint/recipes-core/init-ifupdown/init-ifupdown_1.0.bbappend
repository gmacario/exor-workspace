FILESEXTRAPATHS := "${THISDIR}/files"

PR := "${PR}.x14"

do_install_append () {

    # interfaces file is initially generated by gen_network_interfaces() in /etc/init.d/networking
    rm ${D}${sysconfdir}/network/interfaces
}

INITSCRIPT_PARAMS = '${@base_contains("MACHINE_FEATURES", "fastboot", "start 4 5 . stop 40 0 6 1 .", "start 16 5 . stop 40 0 6 1 .",d)}'

INITSCRIPT_PARAMS_wu16 = "start 35 5 . stop 40 0 6 1 ."

