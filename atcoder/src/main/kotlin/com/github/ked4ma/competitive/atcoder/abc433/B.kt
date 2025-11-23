package com.github.ked4ma.competitive.atcoder.abc433

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList()
    for (i in 0 until N) {
        var ans = -1
        for (j in (0 until i).reversed()) {
            if (A[i] < A[j]) {
                ans = j + 1
                break
            }
        }
        println(ans)
    }
}
