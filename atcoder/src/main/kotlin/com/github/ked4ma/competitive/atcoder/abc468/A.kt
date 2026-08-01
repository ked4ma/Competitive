package com.github.ked4ma.competitive.atcoder.abc468

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList()
    var ans = 0
    for (i in 0 until N - 2) {
        if (A[i] < A[i + 1] && A[i + 1] > A[i + 2]) ans++
    }
    println(ans)
}
