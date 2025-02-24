package com.github.ked4ma.competitive.atcoder.abc394

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = nextCharArray()
    var i = S.size - 2
    while (i >= 0) {
        if (S[i] == 'W' && S[i + 1] == 'A') {
            S[i] = 'A'
            S[i + 1] = 'C'
        }
        i--
    }
    println(S.concatToString())
}
