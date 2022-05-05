apply {
    plugin("kotlin")
}
buildscript {
    repositories {
        gradlePluginPortal()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", "1.6.21"))
    }
}
dependencies {
    implementation(gradleKotlinDsl())
    implementation(kotlin("stdlib", "1.6.21"))
}
repositories {
    gradlePluginPortal()
}
