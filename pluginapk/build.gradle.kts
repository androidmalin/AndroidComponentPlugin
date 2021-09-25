plugins {
    id("com.android.application")
}

android {
    compileSdk = AppConfig.compileSdkVersion
    buildToolsVersion = AppConfig.buildToolsVersion
    ndkVersion = AppConfig.ndkVersion

    defaultConfig {
        resourceConfigurations.addAll(arrayOf("zh", "en"))
        minSdk = AppConfig.minSdkVersion
        targetSdk = AppConfig.targetSdkVersion
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName
    }

//    //https://juejin.cn/post/7002497671558610951
//    //https://fucknmb.com/2017/11/15/aapt2%E9%80%82%E9%85%8D%E4%B9%8B%E8%B5%84%E6%BA%90id%E5%9B%BA%E5%AE%9A/
//    androidResources {
//        val publicFile = project.rootProject.file("runtime_symbol_list/com.malin.plugin.public.txt")
//        if (publicFile.exists()) {
//            project.logger.error("$publicFile exists, apply it.")
//            additionalParameters.addAll(
//                listOf(
//                    "--package-id",
//                    "0x80",
//                    "--stable-ids",
//                    "$publicFile"
//                )
//            )
//        } else {
//            project.logger.error("$publicFile not exists, generate it.")
//            additionalParameters.addAll(listOf("--package-id", "0x80", "--emit-ids", "$publicFile"))
//        }
//    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    compileOnly(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    compileOnly(DependenciesConfig.APP_COMPAT)
}
