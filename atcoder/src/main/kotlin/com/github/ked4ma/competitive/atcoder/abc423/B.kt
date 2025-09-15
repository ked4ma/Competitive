package com.github.ked4ma.competitive.atcoder.abc423

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val L = nextIntList()

    val l = L.indexOfFirst { it == 1 }
    val r = L.indexOfLast { it == 1 }
    if (l < r) {
        println(r - l)
    } else {
        println(0)
    }
}
