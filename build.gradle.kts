buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${KotlinConstants.ANDROID_GRADLE_VERSION}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${KotlinConstants.KOTLIN_VERSION}")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }

    gradle.projectsEvaluated {
        tasks.withType<JavaCompile> {
            options.encoding = "UTF-8"
            val compilerArgs = options.compilerArgs
            compilerArgs.add("-Xlint:unchecked")
            compilerArgs.add("-Xlint:deprecation")
            compilerArgs.add("-Xdiags:verbose")
        }
    }
}

tasks.create("clean", Delete::class.java) {
    delete(rootProject.buildDir)
}
