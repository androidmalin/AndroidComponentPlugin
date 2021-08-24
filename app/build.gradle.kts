plugins {
    id("com.android.application")
    id("com.guardsquare.proguard")
    kotlin("android")
}

android {
    compileSdk = AppConfig.compileSdkVersion
    buildToolsVersion = AppConfig.buildToolsVersion
    ndkVersion = AppConfig.ndkVersion
    defaultConfig {
        resourceConfigurations.addAll(arrayOf("zh", "en"))
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdkVersion
        targetSdk = AppConfig.targetSdkVersion
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName
        ndk {
            abiFilters.addAll(AppConfig.abi)
        }
    }

    signingConfigs {
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
        }
        getByName("release") {
            isMinifyEnabled = false
            isShrinkResources = false
            signingConfig = signingConfigs.getByName("release")
        }
    }

    //https://www.guardsquare.com/manual/setup/upgrading
    proguard {
        configurations {
            register("release") {
                defaultConfiguration("proguard-android-optimize.txt")
                configuration("proguard-rules.pro")
            }
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(DependenciesConfig.STD_LIB)
    implementation(DependenciesConfig.APP_COMPAT)
    implementation(DependenciesConfig.KTX_CORE)
    implementation(DependenciesConfig.ASYNC_LAYOUT)
    implementation(project(":pluingImpl"))
    implementation(project(":hiddenapibypass"))
    implementation(project(":restrictionbypass"))
}