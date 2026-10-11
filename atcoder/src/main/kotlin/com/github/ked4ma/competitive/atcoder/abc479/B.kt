package com.github.ked4ma.competitive.atcoder.abc479

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val S = next()
    println(S.split("S").maxOf { it.length })
}
