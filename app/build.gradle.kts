plugins {
    id("com.android.application")
    id("com.guardsquare.proguard")
    kotlin("android")
    id("io.gitlab.arturbosch.detekt") version "1.18.0"
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
            isMinifyEnabled = false
            isShrinkResources = false
            signingConfig = signingConfigs.getByName("release")
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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
        // Target version of the generated JVM bytecode. It is used for type resolution.
        this.jvmTarget = "11"
    }
}

detekt {
    // Version of Detekt that will be used. When unspecified the latest detekt
    // version found will be used. Override to stay on the same version.
    toolVersion = "1.18.0"

    // The directories where detekt looks for source files.
    // Defaults to `files("src/main/java", "src/test/java", "src/main/kotlin", "src/test/kotlin")`.
    source = files("src/main/java")

    // Builds the AST in parallel. Rules are always executed in parallel.
    // Can lead to speedups in larger projects. `false` by default.
    parallel = true

    // Turns on all the rules. `false` by default.
    allRules = true

    // Disables all default detekt rulesets and will only run detekt with custom rules
    // defined in plugins passed in with `detektPlugins` configuration. `false` by default.
    disableDefaultRuleSets = false

    // Adds debug output during task execution. `false` by default.
    debug = false

    // If set to `true` the build does not fail when the
    // maxIssues count was reached. Defaults to `false`.
    ignoreFailures = true

    // Android: Don't create tasks for the specified build types (e.g. "release")
    ignoredBuildTypes = listOf("release")

    reports {
        xml.enabled = false
        txt.enabled = false
        sarif.enabled = false
        html {
            enabled = true
            destination = file("build/reports/detekt/detekt.html")
        }
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
