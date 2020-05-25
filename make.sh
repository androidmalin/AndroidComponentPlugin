#!/bin/bash
./gradlew clean
rm -rf app/src/main/assets/*.apk
./gradlew -q pluginapk:assembleDebug
cp pluginapk/build/outputs/apk/debug/pluginapk-debug.apk app/src/main/assets/
