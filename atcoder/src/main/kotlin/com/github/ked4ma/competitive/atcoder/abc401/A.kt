package com.github.ked4ma.competitive.atcoder.abc401

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    println(if (N in 200 ..299) "Success" else "Failure")
}
