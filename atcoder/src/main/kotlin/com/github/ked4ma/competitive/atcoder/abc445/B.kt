package com.github.ked4ma.competitive.atcoder.abc445

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val S = times(N) { next() }
    val m = S.maxOf { it.length }
    for (s in S) {
        val n = m - s.length
        println("${".".repeat(n / 2)}$s${".".repeat(n / 2)}")
    }
}
