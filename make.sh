#!/bin/bash
rm -rf app/src/main/assets/pluginapk-debug.apk
./gradlew -q pluginapk:assembleDebug -x lint --parallel --offline --continue &&
cp pluginapk/build/outputs/apk/debug/pluginapk-debug.apk app/src/main/assets/

rm -rf app/src/main/assets/receiverPlugin-debug.apk
./gradlew -q receiverPlugin:assembleDebug -x lint --parallel --offline --continue &&
cp receiverPlugin/build/outputs/apk/debug/receiverPlugin-debug.apk app/src/main/assets/

rm -rf app/src/main/assets/pluginProvider-debug.apk
./gradlew -q pluginProvider:assembleDebug -x lint --parallel --offline --continue &&
cp pluginProvider/build/outputs/apk/debug/pluginProvider-debug.apk app/src/main/assets/