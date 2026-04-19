plugins {
    alias(libs.plugins.kotlinCodeforcesGradlePlugin)
    id("contest")
    id("version")
    id("jvmtoolchain-21")
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
