package com.github.ked4ma.competitive.atcoder.abc394

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val S = times(N) { next() }.sortedBy { it.length }
    println(S.joinToString(""))
}
