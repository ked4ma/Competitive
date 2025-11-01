import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    alias(libs.plugins.kotlinCodeforcesGradlePlugin)
}

group = "com.github.ked4ma.competitive.codeforces"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

sourceSets {
    if (hasProperty("contest")) {
        println("src/main/kotlin/com/github/ked4ma/competitive/codeforces/${findProperty("contest")}")
        getByName("main").kotlin.setSrcDirs(
            setOf(
                "src/main/kotlin/com/github/ked4ma/competitive/codeforces/${findProperty("contest")}",
            )
        )
    }
}

dependencies {
    implementation(project(":common"))
    testImplementation(project(":testing"))
    testImplementation(libs.bundles.testing)
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

kotlin {
    jvmToolchain(21)
}
