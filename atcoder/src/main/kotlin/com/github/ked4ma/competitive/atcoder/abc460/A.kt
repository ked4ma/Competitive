package com.github.ked4ma.competitive.atcoder.abc460

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    var (N, M) = nextIntList()
    var ans = 0
    while (M != 0) {
        val x = N % M
        ans++
        M = x
    }
    println(ans)
}
