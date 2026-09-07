package com.github.ked4ma.competitive.atcoder.abc474_na

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val P = nextIntList()
    var range = -9..0
    for (i in 0 until N) {
        if (i % 10 == 0) range = range.first + 10..range.last + 10
        if (P[i] !in range) {
            println("No")
            return
        }
    }
    println("Yes")
}
