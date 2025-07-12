package com.github.ked4ma.competitive.atcoder.abc412

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    var ans = 0
    repeat(N) {
        val (A, B) = nextIntList()
        if (B > A) ans++
    }
    println(ans)
}
