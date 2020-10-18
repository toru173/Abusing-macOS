#!/bin/sh

export PATH=/bin:/sbin

# Populating /dev/fd/ with mount_fdesc
/sbin/mount -t fdesc -o union stdin /dev

/bin/sh -i

