import util.library
import util.libs

plugins {
    kotlin("jvm") apply false
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.library("kotlinxCoroutinesCore"))
    implementation(libs.library("ktorClientCore"))
    implementation(libs.library("ktorClientCio"))
    implementation(libs.library("jsoup"))
    implementation(libs.library("kotlinxSerializationJson"))
    testImplementation(libs.library("junitJupiter"))
}

tasks.test {
    useJUnitPlatform()
}
