import util.bundle
import util.libs

plugins {
    kotlin("jvm") apply false
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation(libs.bundle("testing"))
}

tasks.test {
    useJUnitPlatform()
}
