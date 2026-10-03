package com.github.ked4ma.competitive.atcoder.abc478

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val m = M / N
    val k = M % N
    repeat(N) { i ->
        println(m + if (i < k) 1 else 0)
    }
}
