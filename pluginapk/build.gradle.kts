@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.application")
    id("project-report")
    id("com.guardsquare.proguard")
    kotlin("android")
}

android {
    compileSdk = AppConfig.compileSdkVersion
    buildToolsVersion = AppConfig.buildToolsVersion
    ndkVersion = AppConfig.ndkVersion

    defaultConfig {
        applicationId = "com.malin.plugin"
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
            // https://www.guardsquare.com/manual/setup/upgrading
            isMinifyEnabled = false
            isShrinkResources = false
            signingConfig = signingConfigs.getByName("release")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

// https://www.guardsquare.com/manual/setup/upgrading
proguard {
    configurations {
        register("release") {
            defaultConfiguration("proguard-android-optimize.txt")
            configuration("proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(DependenciesConfig.APP_COMPAT)
    implementation("com.google.android.material:material:1.6.1") {
        exclude(group = "androidx.appcompat", module = "appcompat")
    }
}
