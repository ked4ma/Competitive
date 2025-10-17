import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

plugins {
    id("com.github.ben-manes.versions") version "0.53.0"
}

group = "com.github.ked4ma.competitive"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks.withType<DependencyUpdatesTask> {
    rejectVersionIf {
        val unstableKeywords = listOf("alpha", "beta", "rc", "m", "preview", "eap", "snapshot")
        unstableKeywords.any { candidate.version.contains(it, ignoreCase = true) }
    }
}
