plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdk = AppConfig.compileSdkVersion
    buildToolsVersion = AppConfig.buildToolsVersion
    ndkVersion = AppConfig.ndkVersion

    defaultConfig {
        resourceConfigurations.addAll(arrayOf("zh", "en"))
        minSdk = AppConfig.minSdkVersion
        targetSdk = AppConfig.targetSdkVersion
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
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
}

dependencies {
    implementation(DependenciesConfig.STD_LIB)
    implementation(DependenciesConfig.APP_COMPAT)
    implementation(DependenciesConfig.KTX_CORE)
}
