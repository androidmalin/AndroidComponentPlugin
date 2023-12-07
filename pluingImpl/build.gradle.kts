@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdk = AppConfig.COMPILE_SDK_VERSION
    buildToolsVersion = AppConfig.BUILD_TOOLS_VERSION
    ndkVersion = AppConfig.NDK_VERSION
    namespace = "com.malin.plugin.impl"
    defaultConfig {
        resourceConfigurations.addAll(arrayOf("zh", "en"))
        minSdk = AppConfig.MIN_SDK_VERSION
        targetSdk = AppConfig.TARGET_SDK_VERSION
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(DependenciesConfig.STD_LIB)
    implementation(DependenciesConfig.APP_COMPAT)
    implementation(DependenciesConfig.KTX_CORE)
}
