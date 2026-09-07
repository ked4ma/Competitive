package com.github.ked4ma.competitive.atcoder.abc474_na

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val P = nextIntList()
    val idx = P.withIndex().associate { (i, n) -> n to i }.toMutableMap()
    repeat(Q) { i ->
        val a = nextInt()
        idx[a] = N + i
    }
    println(idx.entries.sortedBy { it.value }.joinToString(" ") { it.key.toString() })
}
