#!/usr/bin/env bash
# shellcheck disable=SC2034
# https://github.com/shwenzhang/AndResGuard/blob/master/doc/how_to_work.zh-cn.md
# shellcheck disable=SC2038
find . -name "outapk" -type d |  xargs rm -rf
find . -name "*.apk" -type f |  xargs rm -rf

cd .. &&  \
./gradlew clean && ./gradlew assembleRelease
cd resguard || exit

mkdir -p outapk
android_sdk_home=$ANDROID_HOME

cp ../app/build/outputs/apk/release/app-release.apk .
mv app-release.apk input.apk

java -jar AndResGuard-cli-1.2.21.jar input.apk \
-out outapk \
-zipalign "$android_sdk_home"/build-tools/32.0.0/zipalign \
-signatureType v2 \
-config config.xml \
-signature ../plugin.jks plugin plugin plugin \
-7zip /usr/local/bin/7z

adb uninstall com.malin.hook
adb install ./outapk/input_7zip_aligned_signed.apk
adb shell am start com.malin.hook/.MainActivity