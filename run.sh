#!/bin/bash
adb -s CVH7N15C03002357 uninstall com.malin.hook
gradle clean && gradle -q assembleDebug -x lint --no-build-cache --no-daemon --parallel --offline --continue &&
adb -s CVH7N15C03002357 install -r ./app/build/outputs/apk/debug/app-debug.apk &&
adb -s CVH7N15C03002357 shell am start com.malin.hook/.MainActivity
