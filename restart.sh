#!/bin/bash
first_device=`adb devices | awk  'NR==2' | awk  '{print $1}'`
packageName="com.malin.hook"
adb -s ${first_device} shell am start ${packageName}/.MainActivity