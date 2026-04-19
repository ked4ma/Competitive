rootProject.name = "Competitive"

pluginManagement {
    includeBuild("gradle-conventions")
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

include("testing")
include("atcoder")
include("codeforces")
include("common")
include("training")
