package com.github.ked4ma.competitive.atcoder.abc382

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, D) = nextIntList()
    val S = nextCharArray()
    var d = D
    var i = N - 1
    while (d > 0) {
        if (S[i] == '@') {
            S[i] = '.'
            d--
        }
        i--
    }
    println(S.joinToString(""))
}
