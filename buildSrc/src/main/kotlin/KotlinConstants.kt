object KotlinConstants {
    const val gradle_version = "7.3.1"
    const val kotlin_version = "1.7.22"
}

object AppConfig {
    const val compileSdkVersion = 33
    const val buildToolsVersion = "33.0.1"
    const val ndkVersion = "25.1.8937393"
    const val applicationId = "com.malin.hook"
    const val minSdkVersion = 15
    const val targetSdkVersion = 32
    const val versionCode = 200
    const val versionName = "200.0"
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
