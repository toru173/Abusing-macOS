# Backburner Projects
Projects that have begun, but are currently on the backburner


## Tricking launchd
How does the behaviour of launchd change given the presence or absence of rc.cdrom? What is checked and verified in normal boot that is skipped over in the installation environment? We know the install user is root, and recovery mode is required to modify/disable SIP and use `bless` - could this be used to attack macOS?

Project Status: Succesfully booted macOS normally with the presence of rc.cdrom. Currently attempting to boot an install image (BaseSystem.dmg) with the *absence* of rc.cdrom. Currently in progress.


## Terrorising BridgeOS
As part of my university studies I submitted a project proposal in January 2020 to modify the open source QEMU emulator to allow for the running and then analysis of Apple’s BridgeOS.

BridgeOS is the operating system that run’s on Apple’s ‘iBridge’ CPU, responsible for managing secure boot, disk encryption and other cryptographically sensitive operations for Apple’s latest Macintosh computers. Existing knowledge includes static analysis of the operating system, analysis of communication of the iBridge CPU with the host CPU running macOS and an existing effort to modify QEMU to run iOS, a closely related operating system that runs on Apple’s iPhone. To my knowledge there is no effort to dynamically analyse the operating system, though that may have changed as the chip has recently been compromised (https://twitter.com/qwertyoruiopz/status/1237400079465689088)

I am familiar with macOS’s early boot process (which is very similar to that of iOS and iBridge), I have existing experience in software and hardware reverse engineering and a familiarity with QEMU that extends over a decade. Initially, I would attempt to load and run a kernel image (similar to Linux’s initrd); with sufficient time I would extend the emulation to userspace as well. Resources I've used to begin my research include my own CoreXNU project, Aleph Security's iOS in QEMU research (https://alephsecurity.com/2019/06/17/xnu-qemu-arm64-1/), zhuowei's similar research (https://worthdoingbadly.com/xnuqemu2/) and winocm's Darwin on Arm project (https://github.com/darwin-on-arm).

Project Status: Approval obtained from relevant parties; however, the University has since changed their course structure disallowing independant projects so only research and review work has been completed.


## macOS on NTFS
macOS contains built in read/write/formatting libraries for Microsoft's NTFS. Springboarding off a small EFI System Partition and macOS's boot!=root technology, is it possible to load these libraries and root macOS from NTFS?

Project Status: Theoretical only. This has not yet been investigated