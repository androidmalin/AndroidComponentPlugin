#!/bin/bash
rm -rf ./app/src/main/assets/*.apk
rm -rf ./app/build
rm -rf ./pluginapk/build
./gradlew -q clean &&
./gradlew -q cleanBuildCache &&
./gradlew -q pluginapk:assembleDebug &&
cp ./pluginapk/build/outputs/apk/debug/pluginapk-debug.apk ./app/src/main/assets/
