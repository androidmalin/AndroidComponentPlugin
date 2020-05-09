#!/bin/bash
sudo kill `ps -ef | grep "Android\ Studio.app" | grep "studio" | awk 'NR==1 {print$2}'` &&
rm -rf .idea/ .gradle/ && \
find . -name "build" -type d | xargs rm -rf && \
find . -name "*.iml" -type f | xargs rm -rf && \
find . -name ".settings" -type d | xargs rm -rf && \
find . -name ".project" -type f | xargs rm -rf && \
find . -name ".classpath" -type f | xargs rm -rf && \
sleep 1 && \
open ./build.gradle
