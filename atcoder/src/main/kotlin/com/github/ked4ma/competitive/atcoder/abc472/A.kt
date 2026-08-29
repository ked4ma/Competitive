package com.github.ked4ma.competitive.atcoder.abc472

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = nextCharArray()
    for (i in S.indices) {
        if (S[i] != 'A') S[i] = '.'
    }
    println(S.concatToString())
}
