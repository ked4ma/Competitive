plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
rootProject.name = "Competitive"
include("testing")
include("atcoder")
include("codeforces")
include("common")
include("training")
