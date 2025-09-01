package com.github.ked4ma.competitive.atcoder.abc421

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val S = times(N) {
        next()
    }
    val (X, Y) = nextList().let { (X, Y) -> X.toInt() - 1 to Y }
    println(if (S[X] == Y) "Yes" else "No")
}
