package com.github.ked4ma.competitive.atcoder.abc436

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val S = next()
    println("o".repeat(N - S.length) + S)
}
