package com.github.ked4ma.competitive.atcoder.abc402

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = nextCharArray()
    val ans = StringBuilder()
    for (c in S) {
        if (c in 'A'..'Z') ans.append(c)
    }
    println(ans)
}
