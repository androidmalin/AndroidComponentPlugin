#!/bin/bash
#pip3 install -U quark-engine
#freshquark
#https://github.com/quark-engine/quark-engine
#quark -a first.apk -C
#quark -a app-release.apk -d
#quark -a app-release.apk -s
quark -a ./app/build/outputs/apk/release/app-release.apk -l detailed

#腾讯金刚 ，扫描常见android 漏洞
#https://service.security.tencent.com/kingkong