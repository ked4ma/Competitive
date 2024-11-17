plugins {
    alias(libs.plugins.kotlinCommonGradlePlugin)
}

group = "com.github.ked4ma.competitive.test"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.kotlinxCoroutinesCore)
    implementation(libs.ktorClientCore)
    implementation(libs.ktorClientCio)
    implementation(libs.jsoup)
    implementation(libs.kotlinxSerializationJson)
    testImplementation(libs.junitJupiter)
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}
