#!/bin/bash
#pip3 install -U quark-engine
#pip3 install --upgrade quark-engine
#Now you can download the Quark official ruleset to your home directory with a simple command.
#freshquark

#https://github.com/quark-engine/quark-engine
#quark -a first.apk -C
#quark -a app-release.apk -d
#quark -a app-release.apk -s
quark -a ./app/build/outputs/apk/release/app-release.apk -l detailed
#quark -a ./app/build/outputs/apk/release/app-release.apk -s -w quark_report.html

#腾讯金刚 ，扫描常见android 漏洞
#https://service.security.tencent.com/kingkong
#https://service.security.tencent.com/uploadimg_dir/jingang/e1f1bcdf2057bc02f5b75c50c4f5574b.html