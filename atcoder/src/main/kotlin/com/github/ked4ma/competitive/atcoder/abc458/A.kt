package com.github.ked4ma.competitive.atcoder.abc458

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = next()
    val N = nextInt()
    println(S.substring(N until S.length - N))
}
