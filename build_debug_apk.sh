#!/bin/sh
./gradlew :pluginapk:clean && \
./gradlew :pluginapk:assembleDebug && \
cp pluginapk/build/outputs/apk/debug/pluginapk-debug.apk ./app/src/main/assets/pluginapk-debug.apk && \
./gradlew :app:clean && \
adb uninstall com.malin.plugin
adb uninstall com.malin.hook
./gradlew :app:installDebug && \
adb shell am start com.malin.hook/.MainActivity