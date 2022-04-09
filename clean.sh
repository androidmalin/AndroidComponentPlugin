#!/bin/bash
find . -name "build" -type d | xargs rm -rf
find . -name ".gradle" -type d | xargs rm -rf
find . -name ".idea" -type d | xargs rm -rf
find . -name "infer-out" -type d | xargs rm -rf

find ./redex -name "*.txt" -type f |  xargs rm -rf
find ./redex -name "*.idsig" -type f |  xargs rm -rf
find ./redex -name "*.json" -type f |  xargs rm -rf
find ./redex -name "*.apk" -type f |  xargs rm -rf

find ./resguard -name "outapk" -type d |  xargs rm -rf
find ./resguard -name "*.apk" -type f |  xargs rm -rf