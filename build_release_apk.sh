#!/bin/bash
./gradlew :pluginapk:clean && \
./gradlew :pluginapk:assembleRelease && \
cp pluginapk/build/outputs/apk/release/pluginapk-release.apk ./app/src/main/assets/pluginapk-debug.apk && \
cp pluginapk/build/outputs/mapping/release/mapping.txt ./app/ && \
./gradlew :app:clean && \
./gradlew :app:assembleRelease && \
adb uninstall com.malin.plugin
adb uninstall com.malin.hook
adb install app/build/outputs/apk/release/app-release.apk && \
first_device=$(adb devices | awk  'NR==2' | awk  '{print $1}')
packageName="com.malin.hook"
echo "apk will install to ""$first_device"
adb -s "$first_device" shell am start $packageName/.MainActivity