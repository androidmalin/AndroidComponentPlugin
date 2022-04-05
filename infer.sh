#!/bin/bash
#brew install infer
#or make from source code
./gradlew clean
# shellcheck disable=SC2038
find . -type d -name "infer-out" | xargs rm -rf
infer run -- ./gradlew build
infer explore --html
open ./infer-out/report.html/index.html
