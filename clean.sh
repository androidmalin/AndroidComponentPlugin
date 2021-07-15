#!/bin/bash
rm -rf .idea/ .gradle/ 
find . -name "build" -type d | xargs rm -rf
find . -name "*.iml" -type f | xargs rm -rf
find . -name ".cxx" -type d | xargs rm -rf
find . -name "bin" -type d | xargs rm -rf
