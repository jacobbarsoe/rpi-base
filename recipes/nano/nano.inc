DESCRIPTION = "GNU nano (Nano's ANOther editor, or \
Not ANOther editor) is an enhanced clone of the \
Pico text editor."
HOMEPAGE = "http://www.nano-editor.org/"
LICENSE = "GPLv2"
SECTION = "console/utils"
DEPENDS = "ncurses-dev"
RDEPENDS_${PN} = "ncurses-terminfo"

PV_MAJOR = "${@bb.data.getVar('PV',d,1).split('.')[0]}.${@bb.data.getVar('PV',d,1).split('.')[1]}"

SRC_URI = "http://www.nano-editor.org/dist/v${PV_MAJOR}/nano-${PV}.tar.gz"

inherit autotools-autoreconf

EXTRA_OECONF = "\
    --disable-largefile \
    --disable-rpath \
    --disable-extra \
    --disable-help \
    --disable-mouse \
    --disable-speller \
    --disable-glibtest \
    --disable-utf8 \
"

inherit gettext