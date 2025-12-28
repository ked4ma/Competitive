package com.github.ked4ma.competitive.atcoder.abc438

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (D, F) = nextIntList()
    println(7 - (D - F) % 7)
}
