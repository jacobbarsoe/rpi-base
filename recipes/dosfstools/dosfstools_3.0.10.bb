# dosfstools OE build file
# Copyright (C) 2004-2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION = "DOS FAT Filesystem Utilities"
LICENSE = "GPLv3"

BBCLASSEXTEND = "native sdk"

SRC_URI = "http://www.daniel-baumann.ch/software/dosfstools/dosfstools-${PV}.tar.bz2"

# output of getconf LFS_CFLAGS
#
CFLAGS_append = ' -D_LARGEFILE_SOURCE -D_FILE_OFFSET_BITS=64'
CFLAGS_append_libc-uclibc = ' ${@base_contains("DISTRO_FEATURES", "largefile", "-D_LARGEFILE_SOURCE -D_FILE_OFFSET_BITS=64", "", d)}'

do_install () {
	oe_runmake "PREFIX=${D}" "SBINDIR=${D}${sbindir}" \
		   "MANDIR=${D}${mandir}" "DOCDIR=${D}${docdir}" install
}

PACKAGES =+ "${PN}-mkfs ${PN}-fsck ${PN}-fslabel"

FILES_${PN}-mkfs = "${sbindir}/mkdosfs ${sbindir}/mkfs.*"
FILES_${PN}-fsck = "${sbindir}/dosfsck ${sbindir}/fsck.*"
FILES_${PN}-fslabel = "${sbindir}/dosfslabel"

RPROVIDES_${PN}-mkfs_recipe-target = "util/mkfs.msdos util/mkfs.vfat util/mkdosfs"
RPROVIDES_${PN}-fsck_recipe-target = "util/fsck.msdos util/fsck.vfat util/dosfsck"
RPROVIDES_${PN}-fslabel_recipe-target = "util/dosfslabel"

RDEPENDS_${PN} = "${PN}-mkfs ${PN}-fsck ${PN}-fslabel"
DEPENDS_${PN} = "${PN}-mkfs ${PN}-fsck ${PN}-fslabel"