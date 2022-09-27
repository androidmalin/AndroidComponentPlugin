# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
#https://github.com/ysrc/AndroidObfuseDictionary
#https://github.com/WrBug/FrenziedProguard
# ----------------------------------------------------------------------------
# 混淆的压缩比例，0-7 表示对代码进行迭代优化的次数，optimization可以对代码进行各种优化，每次优化后还可以继续优化，故称之迭代优化
-dontoptimize

# https://blog.csdn.net/wmadao11/article/details/102613078
-allowaccessmodification

# 不做预校验，预校验是作用在Java平台上的，Android平台上不需要这项功能，去掉之后还可以加快混淆速度
-dontpreverify

# 指定不去忽略非公共的库的类的成员
-dontskipnonpubliclibraryclassmembers

# 指定混淆是采用的算法
-optimizations !code/simplification/arithmetic,!code/simplification/cast,!field/*,!class/merging/*

# 指定外部模糊字典 dic.txt 改为混淆文件名，下同
-obfuscationdictionary dic.txt
# 指定class模糊字典
-classobfuscationdictionary dic.txt
# 指定package模糊字典
-packageobfuscationdictionary dic.txt

#-------------------------------common-------------------------------

# 混淆后类型都为小写
-dontusemixedcaseclassnames

# 不跳过非公共的库的类
-dontskipnonpubliclibraryclasses

# 混淆时记录日志
-verbose

# 保留Annotation不混淆,避免混淆泛型;抛出异常时保留代码行号;避免混淆注解、内部类、泛型、匿名类
-keepattributes Exceptions,InnerClasses,Signature,Deprecated,SourceFile,LineNumberTable,*Annotation*,EnclosingMethod,LocalVariableTable,*JavascriptInterface*

# 将源码中有意义的类名转换成SourceFile，用于混淆具体崩溃代码
# hide the original source file name.
-renamesourcefileattribute SourceFile

#==============proguard6.2.2/gradle/src/proguard/gradle/proguard-android-common.pro start======
# 保持哪些类不被混淆
# From default AGP configuration.
# Make sure that such classes are kept as they are
# referenced from the AndroidManifest.xml or other
# resource files. Some rules might be obsoleted by
# aapt generated rules but keep them to be sure.
-dontnote android.support.v4.app.Fragment
-dontnote com.google.vending.licensing.ILicensingService
-dontnote com.android.vending.licensing.ILicensingService

-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgent
-keep public class * extends android.preference.Preference
#noinspection ShrinkerUnresolvedReference
-keep public class * extends android.support.v4.app.Fragment
-keep public class * extends android.app.Fragment
-keep public class com.google.vending.licensing.ILicensingService
-keep public class com.android.vending.licensing.ILicensingService
-keep public class * extends java.lang.Throwable {*;}
-keep public class * extends java.lang.Exception {*;}

# From the default AGP config: keep constructors that are called from
# the system via reflection.
-keep public class * extends android.view.View {
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
    public void set*(...);
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

# For native methods, see http://proguard.sourceforge.net/manual/examples.html#native
-keepclasseswithmembernames class * {
    native <methods>;
}

# keep setters in Views so that animations can still work.
# see http://proguard.sourceforge.net/manual/examples.html#beans
-keepclassmembers public class * extends android.view.View {
   void set*(***);
   *** get*();
}

# For enumeration classes, see http://proguard.sourceforge.net/manual/examples.html#enumerations
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keepclassmembers class * implements android.os.Parcelable {
  #noinspection ShrinkerUnresolvedReference
  public static final android.os.Parcelable$Creator CREATOR;
}

# The support library contains references to newer platform versions.
# Don't warn about those in case this app is linking against an older
# platform version.  We know about them, and they are safe.
-dontwarn android.support.**

# Understand the @Keep support annotation.
-dontnote android.support.annotation.Keep
-keep class android.support.annotation.Keep

-keep @android.support.annotation.Keep class * {*;}

-keepclasseswithmembers class * {
    #noinspection ShrinkerUnresolvedReference
    @android.support.annotation.Keep <methods>;
}

-keepclasseswithmembers class * {
    #noinspection ShrinkerUnresolvedReference
    @android.support.annotation.Keep <fields>;
}

-keepclasseswithmembers class * {
    #noinspection ShrinkerUnresolvedReference
    @android.support.annotation.Keep <init>(...);
}
#==============proguard6.2.2/gradle/src/proguard/gradle/proguard-android-common.pro end======

# We want to keep methods in Activity that could be used in the XML attribute onClick
-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}

-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

-keep class **.R
-keepclassmembers class **.R$* {
    public static <fields>;
}

#-------------------------------common-------------------------------

##-------------------------------androidx-------------------------------
-keep class androidx.appcompat.view.ContextThemeWrapper {*;}
##-------------------------------androidx-------------------------------


#proguard6.2.2/examples/android/proguard-project.txt
# If you wish, you can let the optimization step remove Android logging calls.
#-assumenosideeffects class android.util.Log {
#    public static boolean isLoggable(java.lang.String, int);
#    public static int v(...);
#    public static int i(...);
#    public static int w(...);
#    public static int d(...);
#    public static int e(...);
#}

#proguard6.2.2/examples/android/proguard-project.txt start
# In that case, it's especially useful to also clean up any corresponding
# string concatenation calls.
-assumenoexternalsideeffects class java.lang.StringBuilder {
    public java.lang.StringBuilder();
    public java.lang.StringBuilder(int);
    public java.lang.StringBuilder(java.lang.String);
    public java.lang.StringBuilder append(java.lang.Object);
    public java.lang.StringBuilder append(java.lang.String);
    public java.lang.StringBuilder append(java.lang.StringBuffer);
    public java.lang.StringBuilder append(char[]);
    public java.lang.StringBuilder append(char[], int, int);
    public java.lang.StringBuilder append(boolean);
    public java.lang.StringBuilder append(char);
    public java.lang.StringBuilder append(int);
    public java.lang.StringBuilder append(long);
    public java.lang.StringBuilder append(float);
    public java.lang.StringBuilder append(double);
    public java.lang.String toString();
}

-assumenoexternalreturnvalues class java.lang.StringBuilder {
    public java.lang.StringBuilder append(java.lang.Object);
    public java.lang.StringBuilder append(java.lang.String);
    public java.lang.StringBuilder append(java.lang.StringBuffer);
    public java.lang.StringBuilder append(char[]);
    public java.lang.StringBuilder append(char[], int, int);
    public java.lang.StringBuilder append(boolean);
    public java.lang.StringBuilder append(char);
    public java.lang.StringBuilder append(int);
    public java.lang.StringBuilder append(long);
    public java.lang.StringBuilder append(float);
    public java.lang.StringBuilder append(double);
}
#proguard6.2.2/examples/android/proguard-project.txt end

#https://proandroiddev.com/improving-proguard-name-obfuscation-83b27b34c52a
-repackageclasses 'o'
-printconfiguration proguard-merge-config.txt

#-------------------------------reflect system api.-------------------------------
#-keepclassmembers class android.content.pm.ApplicationInfo {
#  public java.lang.String scanSourceDir;
#  public java.lang.String scanPublicSourceDir;
#  public java.lang.String deviceProtectedDataDir;
#  public java.lang.String credentialProtectedDataDir;
#  #noinspection ShrinkerUnresolvedReference
#  public java.lang.String deviceEncryptedDataDir;
#  public java.lang.String credentialEncryptedDataDir;
#}
#
#-keepclassmembers class android.os.Handler{
#  #noinspection ShrinkerUnresolvedReference
#  final android.os.Handler$Callback mCallback;
#}
#-------------------------------reflect system api.-------------------------------
-dontwarn kotlin.**
-keep class kotlinx.** {*;}
-dontwarn kotlinx.**

#-------------------------------plugin-------------------------------
-keep class com.malin.plugin.PluginResourceUtil {*;}
#-------------------------------plugin-------------------------------