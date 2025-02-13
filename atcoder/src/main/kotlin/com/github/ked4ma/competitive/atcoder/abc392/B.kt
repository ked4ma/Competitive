package com.github.ked4ma.competitive.atcoder.abc392

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val A = nextIntList().toSet()
    val ans = mutableListOf<Int>()
    for (i in 1 .. N) {
        if (i !in A) ans.add(i)
    }
    println(ans.size)
    println(ans.joinToString(" "))
}
