package com.github.ked4ma.competitive.atcoder.abc440

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val T = nextIntList().withIndex().sortedBy { it.value }
    println(T.take(3).map { it.index + 1 }.joinToString(" "))
}
