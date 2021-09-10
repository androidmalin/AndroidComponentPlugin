object KotlinConstants {
    const val gradle_version = "7.0.2"
    const val proguard_gradle = "7.2.0-beta2"
    const val kotlin_version = "1.5.30"
}

object AppConfig {
    const val compileSdkVersion = 31
    const val buildToolsVersion = "31.0.0"
    const val ndkVersion = "23.0.7599858"
    const val applicationId = "com.malin.hook"
    const val minSdkVersion = 16
    const val targetSdkVersion = 31
    const val versionCode = 1
    const val versionName = "1.0"
    val abi = arrayOf("arm64-v8a", "armeabi-v7a", "x86_64", "x86")
}

object DependenciesConfig {

    const val STD_LIB = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${KotlinConstants.kotlin_version}"

    const val APP_COMPAT = "androidx.appcompat:appcompat:1.3.1"

    const val ANNOTATION = "androidx.annotation:annotation:1.2.0"

    const val KTX_CORE = "androidx.core:core-ktx:1.6.0"

    const val ASYNC_LAYOUT = "androidx.asynclayoutinflater:asynclayoutinflater:1.0.0"

    const val X_CRASH = "com.iqiyi.xcrash:xcrash-android-lib:3.0.0"
}
