package com.github.ked4ma.competitive.atcoder.abc473

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList()
    var ans = 0
    for (i in N / 2 until N) {
        ans += A[i]
    }
    println(ans)
}
