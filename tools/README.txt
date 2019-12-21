# appcompat.sh

Given an APK, finds API uses that fall into the blacklist/greylists APIs.

NOTE: appcompat.sh is still under development. It can report
API uses that do not execute at runtime, and reflection uses
that do not exist. It can also miss on reflection uses.

## Instructions

Note that only 64-bit binaries are provided. 32-bit systems are not supported.

### Linux x64

Download veridex-linux.zip, unzip the file and run with:
> ./appcompat.sh --dex-file=test.apk

### macOS

Download veridex-mac.zip, unzip the file and run with:
> ./appcompat.sh --dex-file=test.apk

### Windows 10

Native Windows binaries are not provided, but the Linux binaries can be executed
with Windows Subsystem for Linux (WSL).

Follow the instructions at [this
link](https://docs.microsoft.com/en-us/windows/wsl/install-win10) and install
Ubuntu distribution when given the choice. Once installed, launch an Ubuntu
terminal and follow instructions for Linux.

