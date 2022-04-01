#!/bin/bash
#1.clean cache
# shellcheck disable=SC2038
find . -name "*.txt" -type f |  xargs rm -rf
find . -name "*.idsig" -type f |  xargs rm -rf
find . -name "*.json" -type f |  xargs rm -rf
find . -name "*.apk" -type f |  xargs rm -rf

cd .. &&  \
./gradlew clean && ./gradlew assembleRelease

cd redex || exit

#2.redex
redex -o my_release2-un-signed.apk ../app/build/outputs/apk/release/app-release.apk \
-P ../app/proguard-rules.pro

#sign
apksigner sign --ks ../plugin.jks --ks-pass pass:plugin \
--v1-signing-enabled true \
--v2-signing-enabled true \
--v3-signing-enabled true \
--v4-signing-enabled true \
--in ./my_release2-un-signed.apk \
--out ./my_release2-signed.apk

apksigner verify --verbose ./my_release2-signed.apk

adb uninstall com.malin.hook

#3.install
sleep 1 && \
adb install ./my_release2-signed.apk && \

#4.launch
adb shell am start com.malin.hook/.MainActivity
