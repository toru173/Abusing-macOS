# Booting macOS Catalina from an HFS+ Formatted Volume
Installing macOS Catalina to an HFS+ formatted volume. Research outlined at https://forums.macrumors.com/threads/catalina-on-hfs-a-howto.2185499/

This is a project to prove whether it is possible to boot Catalina from HFS+. At the time I was more familiar working with HFS+ disk images rather than APFS, and ASR was not as flexible as I required

Procedure:
- Create a custom installer that replaces the OSInstall framework from 10.15 with the same one from 10.13 as per https://forums.macrumors.com/threads/is-it-possible-to-install-mojave-and-keep-hfs.2138162/page-3?post=27400317#post-27400317
- Allow the install to complete
- Delete /private/var/db from the installed target
- Ditto /System/Library/Templates/Data to /
- Reboot, and enjoy!

![](https://github.com/toru173/Abusing-macOS/blob/main/Boot%20macOS%20Catalina%20from%20HFS%2B/macOS%20Catalina%20on%20HFS%2B.png)

Project Status: Proof of concept complete