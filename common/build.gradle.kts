plugins {
    alias(libs.plugins.kotlinCommonGradlePlugin)
}

group = "com.github.ked4ma.competitive.common"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation(libs.bundles.testing)
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}
