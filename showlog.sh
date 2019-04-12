#!/bin/bash
first_device=`adb devices | awk  'NR==2' | awk  '{print $1}'`
adb -s $first_device logcat -c
pidcat -s $first_device
