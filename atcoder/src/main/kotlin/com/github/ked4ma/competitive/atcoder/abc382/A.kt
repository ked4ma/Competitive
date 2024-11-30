package com.github.ked4ma.competitive.atcoder.abc382

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, D) = nextIntList()
    val S = next()
    println(N - (S.count { it == '@' } - D))
}
