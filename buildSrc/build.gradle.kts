apply {
    plugin("kotlin")
}
buildscript {
    repositories {
        gradlePluginPortal()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", "1.5.30"))
    }
}
dependencies {
    implementation(gradleKotlinDsl())
    implementation(kotlin("stdlib", "1.5.30"))
}
repositories {
    gradlePluginPortal()
}
