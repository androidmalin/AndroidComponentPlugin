#!/bin/bash
rm -rf app/src/main/assets/pluginActivity-debug.apk
./gradlew -q pluginActivity:assembleDebug -x lint --parallel --offline --continue &&
cp pluginActivity/build/outputs/apk/debug/pluginActivity-debug.apk app/src/main/assets/

rm -rf app/src/main/assets/pluginBroadcastReceiver-debug.apk
./gradlew -q pluginBroadcastReceiver:assembleDebug -x lint --parallel --offline --continue &&
cp pluginBroadcastReceiver/build/outputs/apk/debug/pluginBroadcastReceiver-debug.apk app/src/main/assets/

rm -rf app/src/main/assets/pluginContentProvider-debug.apk
./gradlew -q pluginContentProvider:assembleDebug -x lint --parallel --offline --continue &&
cp pluginContentProvider/build/outputs/apk/debug/pluginContentProvider-debug.apk app/src/main/assets/
