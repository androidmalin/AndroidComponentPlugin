@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.application")
    id("project-report")
    kotlin("android")
}

android {
    compileSdk = AppConfig.compileSdkVersion
    buildToolsVersion = AppConfig.buildToolsVersion
    ndkVersion = AppConfig.ndkVersion
    namespace = "com.malin.plugin"

    defaultConfig {
        // 插件包名和宿主保持一致
        // https://juejin.cn/post/6844903875284058119
        applicationId = AppConfig.applicationId
        resourceConfigurations.addAll(arrayOf("zh", "en"))
        minSdk = AppConfig.minSdkVersion
        targetSdk = AppConfig.targetSdkVersion
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName
    }

    signingConfigs {
        getByName("debug") {
            enableV1Signing = true
            enableV2Signing = true
            enableV3Signing = true
            enableV4Signing = true
        }
        create("release") {
            enableV1Signing = true
            enableV2Signing = true
            keyAlias = "plugin"
            keyPassword = "plugin"
            storeFile = file("../plugin.jks")
            storePassword = "plugin"
        }
    }

    packagingOptions {
        resources.excludes += "META-INF/*"
        resources.excludes += "META-INF/CERT.SF"
        resources.excludes += "META-INF/CERT.RSA"
        resources.excludes += "META-INF/MANIFEST.MF"
    }

    buildTypes {
        getByName("debug") {
            isDebuggable = true
            isCrunchPngs = false
            isMinifyEnabled = false
            isShrinkResources = false
            signingConfig = signingConfigs.getByName("debug")
        }
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            signingConfig = signingConfigs.getByName("release")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
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
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(DependenciesConfig.APP_COMPAT)
    implementation(DependenciesConfig.MATERIAL) {
        exclude(group = "androidx.appcompat", module = "appcompat")
    }
}
