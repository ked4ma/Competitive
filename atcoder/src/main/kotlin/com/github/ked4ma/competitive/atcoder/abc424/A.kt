package com.github.ked4ma.competitive.atcoder.abc424

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (a, b, c) = nextIntList()
    println(if (a == b || b == c || a == c) "Yes" else "No")
}
