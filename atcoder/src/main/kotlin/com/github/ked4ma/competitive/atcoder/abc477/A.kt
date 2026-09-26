package com.github.ked4ma.competitive.atcoder.abc477

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val c = next()[0]
    val l = listOf('B', 'Y', 'R')
    println(l[(l.indexOf(c) + 1) % 3])
}
