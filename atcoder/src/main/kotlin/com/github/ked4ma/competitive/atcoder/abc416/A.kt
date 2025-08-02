package com.github.ked4ma.competitive.atcoder.abc416

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, L, R) = nextIntList()
    val S = next()
    var ans = true
    for (i in L - 1 until R) {
        if (S[i] != 'o') {
            ans = false
            break
        }
    }
    println(if (ans) "Yes" else "No")
}
