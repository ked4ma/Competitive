package com.github.ked4ma.competitive.atcoder.abc406

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (A, B, C, D) = nextIntList()
    println(
        if (C < A || (C == A && D <= B)) "Yes" else "No"
    )
}
