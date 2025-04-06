package com.github.ked4ma.competitive.atcoder.abc400

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val A = nextInt()
    if (400 % A == 0) {
        println(400 / A)
    } else {
        println(-1)
    }
}
