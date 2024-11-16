plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "Competitive"
include("testing")
include("atcoder")
include("codeforces")
include("common")
