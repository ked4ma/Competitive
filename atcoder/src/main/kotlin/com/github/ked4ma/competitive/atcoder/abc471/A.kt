package com.github.ked4ma.competitive.atcoder.abc471

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (A, B) = nextIntList()
    val ans = if (
        A + B == 9 ||
        A - B == 9 ||
        A * B == 9 ||
        A == 9 * B
    ) {
        "Nine"
    } else {
        "Nein"
    }
    println(ans)
}
