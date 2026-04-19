plugins {
    alias(libs.plugins.kotlinAtcoderGradlePlugin)
    id("contest")
    id("version")
    id("jvmtoolchain-24")
}

sourceSets {
    if (hasProperty("contest")) {
        println("src/main/kotlin/com/github/ked4ma/competitive/atcoder/${findProperty("contest")}")
        getByName("main").kotlin.setSrcDirs(
            setOf(
                "src/main/kotlin/com/github/ked4ma/competitive/atcoder/${findProperty("contest")}",
            )
        )
    }
}
