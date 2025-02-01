package com.github.ked4ma.competitive.atcoder.abc390

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextLongList()
    var ok = true
    for (i in 1 until N - 1) {
        if (A[0] * A[i + 1] != A[1] * A[i]) {
            ok = false
            break
        }
    }
    println(if (ok) "Yes" else "No")
}
