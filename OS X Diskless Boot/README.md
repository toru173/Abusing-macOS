# OS X El Capitan Diskless Boot
A project to create a full live OS X environment, similar to the installer but with the full breadth of macOS utilities. Inspired by https://www.insanelymac.com/forum/topic/144128-2009-live-dvd/ but based on OS X El Capitan 10.11.6. The project was undertaken at the end of 2018.

During this project it was identified that the behavious of launchd changes with the presence or absence of /private/etc/rc.cdrom - even if the file is present (but empty), launchd behaves as if it is booting into the installer environment. This behavious is useful early in the boot because it allows us to set up a ramdisk in much the same way the installer does, but becomes a hinderance after loginwindow starts as the behaviour of loginwindow also appears to be set by launchd.

The solution is to create a small script triggered by a LaunchDaemon (here, /private/etc/rc.cleanup and /System/Library/LaunchDaemons/com.apple.liveboot.plist), which effectively deletes rc.cdrom. As all changes made are written to the ramdisk rather than the disk image, the file will return to it's original location on next boot.

During diskless boot, launchd calls /private/etc/rc.cdrom. /private/etc/rc.cdrom  calls /private/etc/rc.liveboot. launchd also proceeds to call other entries in /Library/LaunchAgents, /Library/LaunchDaemons, /System/Library/LaunchAgents and /System/Library/LaunchDaemons as normal, and eventually triggers /private/etc/rc.cleanup which then resprings launchd.

Note that the USB used to hold the compressed image is half the size of the total image when uncompressed; in fact, with a higher compression level it would be possible to have a bootable OS X root that is only slightly larger than the installed files.

![](https://github.com/toru173/Abusing-macOS/blob/main/OS%20X%20Diskless%20Boot/File%20List.png)
![](https://github.com/toru173/Abusing-macOS/blob/main/OS%20X%20Diskless%20Boot/System%20Information%20and%20Root%20Volume.png)

Project Status: Proof of concept complete