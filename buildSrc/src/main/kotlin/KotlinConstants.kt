object KotlinConstants {
    const val gradle_version = "7.3.0"
    const val proguard_gradle = "7.2.2"
    const val kotlin_version = "1.7.10"
}

object AppConfig {
    const val compileSdkVersion = 33
    const val buildToolsVersion = "32.0.0"
    const val ndkVersion = "24.0.8215888"
    const val applicationId = "com.malin.hook"
    const val minSdkVersion = 15
    const val targetSdkVersion = 32
    const val versionCode = 151
    const val versionName = "151.0"
    val abi = arrayOf("arm64-v8a", "armeabi-v7a", "x86_64", "x86")
}

object DependenciesConfig {

    const val STD_LIB = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${KotlinConstants.kotlin_version}"

    const val APP_COMPAT = "androidx.appcompat:appcompat:1.5.1"

    const val ANNOTATION = "androidx.annotation:annotation:1.5.0"

    const val KTX_CORE = "androidx.core:core-ktx:1.9.0"

    const val ASYNC_LAYOUT = "androidx.asynclayoutinflater:asynclayoutinflater:1.0.0"

    const val HIDDEN_API_PASS = "org.lsposed.hiddenapibypass:hiddenapibypass:4.3"

    const val X_CRASH = "com.iqiyi.xcrash:xcrash-android-lib:3.1.0"
}
