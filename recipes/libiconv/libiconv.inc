DESCRIPTION = "GNU libiconv - libiconv is for you if your application needs to support multiple character encodings, but that support lacks from your system."
HOMEPAGE = "http://www.gnu.org/software/libiconv"
SECTION = "libs"
PRIORITY = "optional"

PR = "r3"

BBCLASSEXTEND = "native sdk"

SRC_URI = "ftp://ftp.gnu.org/pub/gnu/libiconv/libiconv-${PV}.tar.gz"

S = "${WORKDIR}/libiconv-${PV}"

inherit autotools

EXTRA_OECONF += "--enable-shared --enable-static --enable-relocatable --disable-rpath"