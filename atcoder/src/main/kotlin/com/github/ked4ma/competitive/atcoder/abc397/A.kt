package com.github.ked4ma.competitive.atcoder.abc397

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val X = nextDouble()
    println(
        if (X >= 38.0) {
            1
        } else if (X >= 37.5) {
            2
        } else {
            3
        }
    )
}
