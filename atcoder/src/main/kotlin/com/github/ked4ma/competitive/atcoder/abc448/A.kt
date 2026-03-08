package com.github.ked4ma.competitive.atcoder.abc448

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    var (N, X) = nextIntList()
    val A = nextIntList()
    for (a in A) {
        if (a < X) {
            println(1)
            X = a
        } else {
            println(0)
        }
    }
}
