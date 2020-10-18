# macOS Mojave on RAID
A project that proves the viability of booting macOS from an APFS container spanning a RAID array. Development detailed at https://forums.macrumors.com/threads/mojave-on-raid-with-apfs-a-howto.2125096/

Initial experiments were met with failure, with macOS stuck in an apparent reboot loop on first boot.

The key to allowing success was the following identified in the kextcache man page:

```
    -U is used during system startup to check whether the cache from which the
    currently-running kernel was loaded is out of date. System startup
    interprets an EX_OSFILE exit code to mean that the system should be
    immediately rebooted off the newer kernel cache
    
    :
    :
    :
    
    If kextcache cannot find or make sense of os_volume/usr/standalone/bootcaches.plist
    the volume is treated as if no caches need updating: success is returned.
```

Note that the same process could potentially be abused to ensure the OS does not validate the kextcache on launch.

Procedure:
- Create the RAID either through the GUI or terminal
- Edit the GPT of the newly mounted volume. Add an EFI partition and an HFS+ or APFS partition as required (thanks Taruga)
- Format the partition
- Mount the formatted volume
- Perform install as normal
- With APFS, expect an error towards the end of the install saying "Running bless to place boot files failed."
- Restart in single user mode. Mount root.
- Rename /usr/standalone/bootcaches.plist
- Reboot and enjoy macOS on RAID

![](https://github.com/toru173/Abusing-macOS/blob/main/macOS%20Mojave%20on%20RAID/macOS%20Mojave%20on%20RAID%20Disk%20Utility.png)
![](https://github.com/toru173/Abusing-macOS/blob/main/macOS%20Mojave%20on%20RAID/macOS%20Mojave%20on%20RAID%20System%20Information.png)

Porject Status: Proof of concept complete
