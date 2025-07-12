package com.github.ked4ma.competitive.atcoder.abc412

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = nextCharArray()
    val T = nextCharArray().toSet()

    var ans = true
    for (i in 2 until S.size) {
        if (S[i] in 'A'..'Z') {
            if (!T.contains(S[i - 1])) {
                ans = false
                break
            }
        }
    }
    println(if (ans) "Yes" else "No")
}
