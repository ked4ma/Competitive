package com.github.ked4ma.competitive.atcoder.abc413

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val A = nextIntList()
    println(if (A.sum() <= M) "Yes" else "No")
}
