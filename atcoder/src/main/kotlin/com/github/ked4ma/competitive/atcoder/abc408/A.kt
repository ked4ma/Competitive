package com.github.ked4ma.competitive.atcoder.abc408

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, S) = nextIntList()
    val T = listOf(0) + nextIntList()
    println(if (T.windowed(2, 1).all { (a, b) -> b - a <= S }) "Yes" else "No")
}
