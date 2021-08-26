plugins {
    id("com.android.library")
}

android {
    compileSdk = AppConfig.compileSdkVersion
    buildToolsVersion = AppConfig.buildToolsVersion

    defaultConfig {
        minSdk = AppConfig.minSdkVersion
        targetSdk = AppConfig.targetSdkVersion
        consumerProguardFiles("consumer-rules.pro")
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    packagingOptions {
        resources.excludes += "META-INF/*"
        resources.excludes += "META-INF/*.properties"
    }
}

dependencies {
    compileOnly(project(":hiddenapibypass_stub"))
    compileOnly(DependenciesConfig.ANNOTATION)
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test:rules:1.4.0")
    androidTestCompileOnly(project(":hiddenapibypass_stub"))
}
