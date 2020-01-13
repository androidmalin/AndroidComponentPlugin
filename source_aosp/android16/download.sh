#!/bin/bash
wget -c http://androidxref.com/4.1.2/raw/libcore/dalvik/src/main/java/dalvik/system/BaseDexClassLoader.java
wget -c http://androidxref.com/4.1.2/raw/libcore/dalvik/src/main/java/dalvik/system/DexClassLoader.java
wget -c http://androidxref.com/4.1.2/raw/libcore/dalvik/src/main/java/dalvik/system/DexFile.java
wget -c http://androidxref.com/4.1.2/raw/libcore/dalvik/src/main/java/dalvik/system/DexPathList.java
wget -c http://androidxref.com/4.1.2/raw/libcore/dalvik/src/main/java/dalvik/system/PathClassLoader.java
wget -c http://androidxref.com/4.1.2/raw/frameworks/base/core/java/android/content/pm/PackageParser.java

# 以下两个类没有
# http://androidxref.com/4.1.2/raw/frameworks/base/core/java/android/content/pm/PackageUserState.java
# http://androidxref.com/4.1.2/raw/frameworks/base/core/java/android/os/UserHandle.java
wget -c http://androidxref.com/4.1.2/raw/frameworks/base/core/java/android/os/UserId.java
wget -c http://androidxref.com/4.1.2/raw/frameworks/base/core/java/android/content/pm/PackageManager.java
wget -c http://androidxref.com/4.1.2/raw/frameworks/base/core/java/android/app/ActivityThread.java
