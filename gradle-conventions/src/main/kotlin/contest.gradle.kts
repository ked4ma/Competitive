import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent
import util.bundle
import util.libs

plugins {
    kotlin("jvm") apply false
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":common"))
    testImplementation(project(":testing"))
    testImplementation(libs.bundle("testing"))
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events(TestLogEvent.FAILED, TestLogEvent.PASSED)
        exceptionFormat = TestExceptionFormat.FULL
        showStandardStreams = true
        showStackTraces = true
        showExceptions = true
    }

    systemProperty("task", System.getProperty("task"))
    systemProperty("branch", System.getProperty("branch"))
}
