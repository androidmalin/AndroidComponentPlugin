#!/bin/bash
find . -name "build" -type d | xargs rm -rf
find . -name ".cxx" -type d | xargs rm -rf
find . -name "bin" -type d | xargs rm -rf
find . -name ".idea" -type d | xargs rm -rf
find . -name ".gradle" -type d | xargs rm -rf
find . -name ".settings" -type d | xargs rm -rf
find . -name "*.iml" -type f | xargs rm -rf
find . -name ".project" -type f | xargs rm -rf
find . -name ".classpath" -type f | xargs rm -rf
find . -name "proguard-merge-config.txt" -type f | xargs rm -rf