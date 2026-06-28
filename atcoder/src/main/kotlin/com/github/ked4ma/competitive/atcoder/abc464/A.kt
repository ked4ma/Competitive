package com.github.ked4ma.competitive.atcoder.abc464

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = next()
    var e = 0
    var w = 0
    for (c in S) {
        when (c) {
            'E' -> e++
            'W' -> w++
        }
    }
    println(if (e > w) "East" else "West")
}
