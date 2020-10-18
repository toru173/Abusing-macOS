# Installing macOS Mojave to HFS+
macOS Mojave forces conversion of all install targets to APFS. As I was more familiar working with HFS+ disk images at the time, I came up with a mechanism to avoid this conversion process, detailed at https://forums.macrumors.com/threads/is-it-possible-to-install-mojave-and-keep-hfs.2138162/post-27400317:

Procedure:
- Use createinstallmedia to create an (8GB) USB installer
- Convert /Volumes/Install\ macOS\ Mojave/Contents/SharedSupport/BaseSystem.dmg to read/write
- Replace /Volumes/macOS\ Base\ System/System/Library/PrivateFrameworks/OSInstaller.framework/Versions/A/OSInstaller with either a patched one from the Hackintosh Community (Thanks crazybirdy!) or the same file from the 10.13 installer
- Compress the dmg again. Rename it Modified\ BaseSystem.dmg, and move it back to /Volumes/Install\ macOS\ Mojave/Contents/SharedSupport/
- Alter /Volumes/Install\ macOS\ Mojave/Library/Preferences/SystemConfiguration/com.apple.boot.plist to point to Modified\ BaseSystem.dmg instead of the original.
- Boot to the installer. Rather than running the graphical install, drop to terminal.
- If it's a blank disk, touch /Volumes/Macintosh\ HD/macOS\ Install\ Data
- Run installer -verboseR -dumplog -pkg /Volumes/Image\ Volume/Install\ macOS\ Mojave.app/Contents/SharedSupport/InstallInfo.plist -target /Volumes/Macintosh\ HD
- Boot into macOS Mojave on HFS+

Note that an attacker could use a similar method to craft a malicious installer

![](https://github.com/toru173/Abusing-macOS/blob/main/Boot%20macOS%20Mojave%20from%20HFS%2B/Modified%20com.apple.boot.plist%20(hirez).png)
![](https://github.com/toru173/Abusing-macOS/blob/main/Boot%20macOS%20Mojave%20from%20HFS%2B/System%20Information%20Screenshot%20(hirez).png)

Project Status: Proof of concept complete