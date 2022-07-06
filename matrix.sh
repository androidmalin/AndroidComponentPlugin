#!/bin/bash
./gradlew clean && ./gradlew assembleRelease \

#需要配置ANDROID_HOME环境变量 /User/xxx/sdk
#需要下载ndk 16.1.4479499 /User/xxx/sdk/ndk/16.1.4479499
root=$(pwd)
android_sdk_home=$ANDROID_HOME
ndk=$android_sdk_home/ndk/16.1.4479499/toolchains/arm-linux-androideabi-4.9/prebuilt/darwin-x86_64/bin/arm-linux-androideabi-nm

echo "$root"
echo "$android_sdk_home"
echo "$ndk"

java -jar ./analyze/matrix-apk-canary-2.0.8.jar \
--apk "$root"/app/build/outputs/apk/release/app-release.apk \
--unzip "$root"/app/build/apk-checker-result \
--mappingTxt "$root"/app/build/outputs/proguard/release/mapping/mapping.txt \
--output "$root"/app/build/apk-checker-result \
--format "mm.html","mm.json" \
--log v \
-manifest \
-fileSize --min 10 --order desc --suffix "png", "jpg", "jpeg", "gif", "arsc" \
-countMethod --group "package" \
-checkResProguard \
-findNonAlphaPng --min 10 \
-checkMultiLibrary \
-uncompressedFile --suffix "png", "jpg", "jpeg", "gif", "arsc" \
-countR \
-duplicatedFile \
-checkMultiSTL --toolnm "$ndk" \
-unusedResources --rTxt "$root"/app/build/intermediates/runtime_symbol_list/release/R.txt --ignoreResources "R.raw.*","R.style.*","R.attr.*","R.id.*","R.string.ignore_*" \
-unusedAssets --ignoreAssets "*.so" \
-unstrippedSo --toolnm "$ndk" \
-countClass --group package \
sleep 2 && \
open "$root"/app/build/apk-checker-result.html