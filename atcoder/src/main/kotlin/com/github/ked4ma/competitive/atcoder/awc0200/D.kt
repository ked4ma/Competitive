package com.github.ked4ma.competitive.atcoder.awc0200

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextIntList()
    val A = nextLongList().map { it.toBigInteger() }
    val S = A.sumOf { it }
    var ans = 0
    for (i in 0 until N) {
        if (A[i] * (N - 1).toBigInteger() >= (S - A[i]) * K.toBigInteger()) ans++
    }
    println(ans)
}
