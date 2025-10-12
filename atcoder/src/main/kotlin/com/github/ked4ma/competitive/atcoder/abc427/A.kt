package com.github.ked4ma.competitive.atcoder.abc427

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = next()
    println(S.slice(0 until S.length / 2) + S.slice(S.length / 2 + 1 until S.length))
}
