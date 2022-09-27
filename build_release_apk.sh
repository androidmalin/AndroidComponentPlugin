#!/bin/bash
./gradlew :pluginapk:clean && \
./gradlew :pluginapk:assembleRelease && \
cp pluginapk/build/outputs/apk/release/pluginapk-release.apk ./app/src/main/assets/pluginapk-debug.apk && \
cp pluginapk/build/outputs/proguard/release/mapping/mapping.txt ./app/ && \
./gradlew :app:clean && \
./gradlew :app:assembleRelease && \
adb uninstall com.malin.plugin
adb uninstall com.malin.hook
run.sh app/build/outputs/apk/release/app-release.apk