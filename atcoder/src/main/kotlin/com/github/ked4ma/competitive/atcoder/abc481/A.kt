package com.github.ked4ma.competitive.atcoder.abc481

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (A, B) = nextIntList()
    println(if (A + B >= 10) 2 else 1)
}
