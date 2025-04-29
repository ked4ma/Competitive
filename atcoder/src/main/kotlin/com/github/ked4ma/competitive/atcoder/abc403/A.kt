package com.github.ked4ma.competitive.atcoder.abc403

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList()
    var ans = 0
    for (i in 0 until N step 2) {
        ans += A[i]
    }
    println(ans)
}
