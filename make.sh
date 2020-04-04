#!/bin/bash
./gradlew clean
rm -rf app/src/main/assets/*.apk
./gradlew -q pluginActivity:assembleDebug
cp pluginActivity/build/outputs/apk/debug/pluginActivity-debug-1.0.apk app/src/main/assets/

./gradlew -q pluginBroadcastReceiver:assembleDebug
cp pluginBroadcastReceiver/build/outputs/apk/debug/pluginBroadcastReceiver-debug-1.0.apk app/src/main/assets/

./gradlew -q pluginContentProvider:assembleDebug
cp pluginContentProvider/build/outputs/apk/debug/pluginContentProvider-debug-1.0.apk app/src/main/assets/

./gradlew -q pluginService:assembleDebug
cp pluginService/build/outputs/apk/debug/pluginService-debug-1.0.apk app/src/main/assets/
