package com.github.ked4ma.competitive.atcoder.abc419

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = next()

    println(
        when (S) {
            "red" -> "SSS"
            "blue" -> "FFF"
            "green" -> "MMM"
            else -> "Unknown"
        }
    )
}
