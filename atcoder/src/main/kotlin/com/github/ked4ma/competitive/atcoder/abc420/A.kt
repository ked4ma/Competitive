package com.github.ked4ma.competitive.atcoder.abc420

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (X, Y) = nextIntList()
    println(((X - 1 + Y) % 12) + 1)
}
