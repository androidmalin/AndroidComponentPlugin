buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${KotlinConstants.gradle_version}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${KotlinConstants.kotlin_version}")
        classpath("com.guardsquare:proguard-gradle:${KotlinConstants.proguard_gradle}")
    }
    configurations.all {
        resolutionStrategy.dependencySubstitution {
            substitute(module("net.sf.proguard:proguard-gradle"))
                .using(module("com.guardsquare:proguard-gradle:${KotlinConstants.proguard_gradle}"))
        }
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

tasks {
    val clean by registering(Delete::class) {
        delete(buildDir)
    }
}