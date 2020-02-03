cd xxx/aosp/ (aosp源码根目录下)


#https://www.jianshu.com/p/5b73540a9470
#生成AIDL文件到当前的aidl-out目录中
./prebuilts/sdk/tools/darwin/bin/aidl \
-Iframeworks/base/core/java/ \
-Iframeworks/base/location/java/ \
-Iframeworks/base/core/java/ \
-Iframeworks/base/location/java/ \
-oaidl-out \
frameworks/base/location/java/android/location/ILocationManager.aidl