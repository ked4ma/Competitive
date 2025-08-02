package com.github.ked4ma.competitive.atcoder.abc417

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, A, B) = nextIntList()
    val S = next()
    println(S.substring(A until N - B))
}
