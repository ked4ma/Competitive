package com.github.ked4ma.competitive.atcoder.abc476

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = next()
    val t = if (S.last() == 'e') "r" else "er"
    println("$S$t")
}
