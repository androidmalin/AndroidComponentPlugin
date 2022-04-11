#!/bin/sh
result=""
./make_plugin.sh
./gradlew clean
./gradlew assembleDebug
host_path=./app/build/outputs/host_id.txt
plugin_path=./app/build/outputs/plugin_id.txt
aapt d resources ./app/build/outputs/apk/debug/app-debug.apk >$host_path
aapt d resources ./app/src/main/assets/pluginapk-debug.apk >$plugin_path
# shellcheck disable=SC2002
img_id=$(cat $plugin_path | grep plugin_img | awk NR==1 | awk '{print $3}')
cat $host_path | grep -q "$img_id"
if [ $? -ne 0 ] ;then
    result="very good"
else
    result="插件图片id和宿主资源id冲突"
fi
echo $result
