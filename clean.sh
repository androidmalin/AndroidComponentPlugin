#!/bin/bash
find . -name "build" -type d | xargs rm -rf
find . -name ".gradle" -type d | xargs rm -rf
find . -name ".idea" -type d | xargs rm -rf
