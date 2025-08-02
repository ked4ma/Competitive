package com.github.ked4ma.competitive.atcoder.abc417

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val A = nextIntList().toMutableList()
    val B = nextIntList()
    for (b in B) {
        A.remove(b)
    }
    println(A.joinToString(" "))
}
