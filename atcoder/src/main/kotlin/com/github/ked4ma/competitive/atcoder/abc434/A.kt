package com.github.ked4ma.competitive.atcoder.abc434

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (W, B) = nextIntList()
    println((W * 1000 + B) / B)
}
