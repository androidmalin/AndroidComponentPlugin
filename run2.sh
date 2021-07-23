#!/bin/bash
#1.java9
#2.build-tools 30.0.1
#3.gradle lasted version
#4.gradle && adb && apksigner env
#5.android11 devices
#6.just for mac
#https://developer.android.com/studio/command-line/apksigner#v4-signing-enabled

packageName="com.malin.hook"
apkPath="./app/build/outputs/apk/debug/app-debug.apk"
start_time=`date +%s`

#1.get first connected device
first_device=`adb devices | awk  'NR==2' | awk  '{print $1}'`
if [ -z "$first_device" ]; then
    say "device is not connected"
    exit
fi

#2.uninstall
echo "apk will install to "$first_device
adb -s $first_device uninstall $packageName

#3.gradle compile project
gradle -q assembleDebug -x lint --parallel --offline --continue &&

#4.apk signer v4
apksigner sign --ks "$HOME/.android/debug.keystore" --ks-pass pass:android --v4-signing-enabled true $apkPath &&

#apksigner verify -v --print-certs ./app/build/outputs/apk/debug/app-debug.apk | more

#5.adb incremental install
adb install --incremental $apkPath

#6.start launcher activity
adb -s $first_device shell am start $packageName/.MainActivity

finish_time=`date +%s`
sumTime=$[ $finish_time - $start_time ]
echo "this shell script execution duration:$sumTime s"

#7.
say "good job"