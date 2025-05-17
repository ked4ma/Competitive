package com.github.ked4ma.competitive.atcoder.abc405

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (R, X) = nextIntList()
    println(
        if (X == 1) {
            if (R in 1600 until 3000) "Yes" else "No"
        } else {
            if (R in 1200 until 2400) "Yes" else "No"
        }
    )
}
