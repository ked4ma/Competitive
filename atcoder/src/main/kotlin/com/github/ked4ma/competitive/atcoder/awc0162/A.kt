package com.github.ked4ma.competitive.atcoder.awc0162

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val S = nextIntList().toIntArray()
    repeat(M) {
        val (t, p) = nextIntList()
        if (p <= S[t - 1]) {
            S[t - 1] -= p
        }
    }
    println(S.count { it == 0 })
}
