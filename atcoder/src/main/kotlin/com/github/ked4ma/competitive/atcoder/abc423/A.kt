package com.github.ked4ma.competitive.atcoder.abc423

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (X, C) = nextIntList()
    println(X / (1000 + C) * 1000)
}
