package com.github.ked4ma.competitive.atcoder.abc426

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = next().groupingBy { it }.eachCount()
    for ((k, v) in S) {
        if (v == 1) println(k)
    }
}
