object KotlinConstants {
    const val ANDROID_GRADLE_VERSION = "8.2.0"
    const val KOTLIN_VERSION = "1.9.21"
}

object AppConfig {
    const val COMPILE_SDK_VERSION = 34
    const val BUILD_TOOLS_VERSION = "34.0.0"
    const val NDK_VERSION = "25.2.9519653"
    const val APPLICATION_ID = "com.malin.hook"
    const val MIN_SDK_VERSION = 15
    const val TARGET_SDK_VERSION = 34
    const val VERSION_CODE = 200
    const val VERSION_NAME = "200.0"
    val ABI = arrayOf("arm64-v8a", "armeabi-v7a", "x86_64", "x86")
}

object DependenciesConfig {

    const val STD_LIB = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${KotlinConstants.KOTLIN_VERSION}"

    const val APP_COMPAT = "androidx.appcompat:appcompat:1.6.1"

    const val ANNOTATION = "androidx.annotation:annotation:1.6.0"

    const val KTX_CORE = "androidx.core:core-ktx:1.10.1"

    const val ASYNC_LAYOUT = "androidx.asynclayoutinflater:asynclayoutinflater:1.0.0"

    const val HIDDEN_API_PASS = "org.lsposed.hiddenapibypass:hiddenapibypass:4.3"

    const val MATERIAL = "com.google.android.material:material:1.9.0"

    const val X_CRASH = "com.iqiyi.xcrash:xcrash-android-lib:3.1.0"
}
