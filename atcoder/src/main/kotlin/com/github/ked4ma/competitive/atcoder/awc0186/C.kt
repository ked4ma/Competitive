package com.github.ked4ma.competitive.atcoder.awc0186

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M, K) = nextIntList()
    val S = nextCharArray()
    var cnt = 0
    for (i in 0 until M - 1) {
        if (S[i] == '1') cnt++
    }
    var ans = 0
    for (i in M - 1 until N) {
        if (S[i] == '1') cnt++
        if (cnt < K) ans++
        if (S[i - (M - 1)] == '1') cnt--
    }
    println(ans)
}
