package com.github.ked4ma.competitive.atcoder.awc0192

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, A, B) = nextLongList()
    repeat(N.toInt()) { i ->
        println(A + B * i)
    }
}
