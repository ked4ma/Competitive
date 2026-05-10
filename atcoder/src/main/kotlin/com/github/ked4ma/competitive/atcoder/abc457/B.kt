package com.github.ked4ma.competitive.atcoder.abc457

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = times(N) {
        nextIntList()
    }
    val (X, Y) = nextIntList()
    println(A[X - 1][Y])
}
