package com.github.ked4ma.competitive.atcoder.abc389

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = next()
    val a = S[0].digitToInt()
    val b = S[2].digitToInt()
    println(a * b)
}
