DESCRIPTION = "IBTP Service for Exor specific linux hardware and BSP"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a26136a158a7bd489efe50329e38188a"

PR = "r7"

SRCNAME = "${BPN}"
SRCBRANCH = "master"
SRCREV = "ddbb2532498511583b58b49f6a388b8e1fb9f92a"

inherit exorint-src qmake2 update-rc.d

SRC_URI += "file://ibtp"

INITSCRIPT_NAME = "ibtp"
INITSCRIPT_PARAMS = "defaults 20"

DEPENDS += "qt4-x11-free"
RDEPENDS_${PN} += "packagegroup-qt-x11-min epad"

# avoid automatic stripping - Yocto will handle it
EXTRA_QMAKEVARS_PRE += "CONFIG+=debug"

FILES_${PN} = "${bindir}/ibtpserver \
	/etc/init.d/ibtp"

S = "${WORKDIR}/git/StandaloneIBTPServer"

do_install() {
	export INSTALL_ROOT=${D}
	oe_runmake install

	install -d ${D}/${sysconfdir}/init.d
	install -m 755 ${WORKDIR}/ibtp ${D}/${sysconfdir}/init.d
}
