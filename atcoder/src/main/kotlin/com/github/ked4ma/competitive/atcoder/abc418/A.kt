package com.github.ked4ma.competitive.atcoder.abc418

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val S = next()
    println(if (S.takeLast(3) == "tea") "Yes" else "No")
}
