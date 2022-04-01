#!/bin/bash
#https://github.com/facebook/redex
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
redex -o my_release1.apk ../app/build/outputs/apk/release/app-release.apk \
-P ../app/proguard-rules.pro \
--sign -s ../plugin.jks -a plugin -p plugin

adb uninstall com.malin.hook

#3.install
sleep 1 && \
adb install ./my_release1.apk && \

#4.launch
adb shell am start com.malin.hook/.MainActivity