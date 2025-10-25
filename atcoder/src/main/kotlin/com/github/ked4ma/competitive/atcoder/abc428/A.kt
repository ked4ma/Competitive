package com.github.ked4ma.competitive.atcoder.abc428

import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (S, A, B, X) = nextIntList()
    val n = (X / (A + B))
    val m = X - n * (A + B)
    println((n * A + min(m, A)) * S)
}
