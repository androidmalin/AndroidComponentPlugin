#!/bin/bash
#.clean cache
# shellcheck disable=SC2038
find . -name "*.apk" -type f |  xargs rm -rf
find . -name "*.txt" -type f |  xargs rm -rf
find . -name "*.idsig" -type f |  xargs rm -rf
find . -name "*.json" -type f |  xargs rm -rf
