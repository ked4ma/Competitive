package com.github.ked4ma.competitive.atcoder.abc470

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    for (i in 1..N) {
        println(if (i % 3 == 0) "Fizz" else i)
    }
}
