package com.github.ked4ma.competitive.atcoder.abc385

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (A, B, C) = nextIntList()
    val ans = if (
        (A == B && A == C) ||
        (A + B == C) ||
        (A + C == B) ||
        (A == B + C)
    ) {
        "Yes"
    } else "No"
    println(ans)
}
