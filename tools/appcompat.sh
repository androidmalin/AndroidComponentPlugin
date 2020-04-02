#!/bin/bash
#
# Copyright (C) 2018 The Android Open Source Project
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

echo "NOTE: appcompat.sh is still under development. It can report"
echo "API uses that do not execute at runtime, and reflection uses"
echo "that do not exist. It can also miss on reflection uses."

# First check if the script is invoked from a prebuilts location.
SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

if [[ -e ${SCRIPT_DIR}/veridex && \
      -e ${SCRIPT_DIR}/hiddenapi-flags.csv && \
      -e ${SCRIPT_DIR}/org.apache.http.legacy-stubs.zip && \
      -e ${SCRIPT_DIR}/system-stubs.zip ]]; then
  exec ${SCRIPT_DIR}/veridex \
    --core-stubs=${SCRIPT_DIR}/system-stubs.zip:${SCRIPT_DIR}/org.apache.http.legacy-stubs.zip \
    --api-flags=${SCRIPT_DIR}/hiddenapi-flags.csv \
    $@
fi

# Otherwise, we want to be at the root for simplifying the "out" detection
# logic.
if [ ! -d art ]; then
  echo "Script needs to be run at the root of the android tree."
  exit 1
fi

# Logic for setting out_dir from build/make/core/envsetup.mk:
if [[ -z "${OUT_DIR}" ]]; then
  if [[ -z "${OUT_DIR_COMMON_BASE}" ]]; then
    OUT=out
  else
    OUT=${OUT_DIR_COMMON_BASE}/${PWD##*/}
  fi
else
  OUT=${OUT_DIR}
fi

if [[ -z "${PACKAGING}" ]]; then
  PACKAGING=${OUT}/target/common/obj/PACKAGING
fi

if [[ -z "${ANDROID_HOST_OUT}" ]]; then
  ANDROID_HOST_OUT=${OUT}/host/linux-x86
fi


${ANDROID_HOST_OUT}/bin/veridex \
    --core-stubs=${PACKAGING}/core_dex_intermediates/classes.dex:${PACKAGING}/oahl_dex_intermediates/classes.dex \
    --api-flags=${PACKAGING}/hiddenapi-flags.csv \
    $@
