package com.github.ked4ma.competitive.atcoder.abc396

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList()
    var ans = false
    for (i in 2 until N) {
        if (A[i - 2] == A[i - 1] && A[i - 1] == A[i]) {
            ans = true
            break
        }
    }
    println(if (ans) "Yes" else "No")
}
