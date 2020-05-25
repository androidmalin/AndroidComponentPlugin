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
# 混淆的压缩比例，0-7
-optimizationpasses 7
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

#保留Annotation不混淆,避免混淆泛型;抛出异常时保留代码行号
-keepattributes Exceptions,InnerClasses,Signature,Deprecated,SourceFile,LineNumberTable,*Annotation*,EnclosingMethod,LocalVariableTable,*JavascriptInterface*
###keepattributes###


# 保持哪些类不被混淆
-keep public class * extends android.app.Fragment
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
#noinspection ShrinkerUnresolvedReference
-keep public class com.google.vending.licensing.ILicensingService
-keep public class com.android.vending.licensing.ILicensingService
-keep public class * extends java.lang.Throwable {*;}
-keep public class * extends java.lang.Exception {*;}

#noinspection ShrinkerUnresolvedReference
-keep public class * extends android.support.v4.app.Fragment
-keep public class * extends android.support.v7.app.AppCompatActivity


-renamesourcefileattribute SourceFile

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

# We want to keep methods in Activity that could be used in the XML attribute onClick
-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}

# For enumeration classes, see http://proguard.sourceforge.net/manual/examples.html#enumerations
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}


#不混淆Parcelable类方法
-keepclassmembers class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator CREATOR;
}

-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    !static !transient <fields>;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

-keep class **.R
-keepclassmembers class **.R$* {
    public static <fields>;
}


# The support library contains references to newer platform versions.
# Don't warn about those in case this app is linking against an older
# platform version.  We know about them, and they are safe.
-dontwarn android.support.**

#-------------------------------Understand the @Keep support annotation.-------------------------------
#noinspection ShrinkerUnresolvedReference
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
#-------------------------------Understand the @Keep support annotation.-------------------------------


# 保持自定义控件类不被混淆
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}

# 保持自定义控件类不被混淆
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

#-------------------------------common-------------------------------

#-------------------------------androidx-------------------------------
#https://stackoverflow.com/a/52592334/3326683
#noinspection ShrinkerUnresolvedReference
-keep class com.google.android.material.** {*;}
-dontwarn com.google.android.material.**
-dontnote com.google.android.material.**
#noinspection ShrinkerUnresolvedReference
-keep class androidx.** {*;}
-keep interface androidx.** {*;}
-dontwarn androidx.**
-dontnote androidx.**
-keep public class * extends androidx.**
#-------------------------------androidx-------------------------------

#-------------------------------androidx Understand the @Keep support annotation.-------------------------------
-keep class androidx.annotation.Keep

-keep @androidx.annotation.Keep class * {*;}

-keepclasseswithmembers class * {
    @androidx.annotation.Keep <methods>;
}

-keepclasseswithmembers class * {
    @androidx.annotation.Keep <fields>;
}

-keepclasseswithmembers class * {
    @androidx.annotation.Keep <init>(...);
}
#-------------------------------androidx Understand the @Keep support annotation.-------------------------------