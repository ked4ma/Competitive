package com.github.ked4ma.competitive.atcoder.abc393

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (a, b) = nextList().map { it == "sick" }
    val ans = if (a && b) {
        1
    } else if (a && !b) {
        2
    } else if (!a && b) {
        3
    } else {
        4
    }
    println(ans)
}
