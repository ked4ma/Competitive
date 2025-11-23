package com.github.ked4ma.competitive.atcoder.abc433

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (X, Y, Z) = nextIntList()
    println(if (X - Z * Y >= 0 && (X - Z * Y) % (Z - 1) == 0) "Yes" else "No")
}
