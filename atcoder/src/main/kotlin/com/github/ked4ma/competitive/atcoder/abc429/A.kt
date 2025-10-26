package com.github.ked4ma.competitive.atcoder.abc429

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    repeat(N) { i ->
        println(if (i + 1 <= M) "OK" else "Too Many Requests")
    }
}
