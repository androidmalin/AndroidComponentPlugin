#!/bin/bash
# shellcheck disable=SC2038
find . -name "build" -type d | xargs rm -rf
find . -name ".gradle" -type d | xargs rm -rf
find . -name ".idea" -type d | xargs rm -rf
find . -name "infer-out" -type d | xargs rm -rf
find . -name "mapping.txt" -type f |  xargs rm -rf
find . -name "proguard-merge-config.txt" -type f |  xargs rm -rf
