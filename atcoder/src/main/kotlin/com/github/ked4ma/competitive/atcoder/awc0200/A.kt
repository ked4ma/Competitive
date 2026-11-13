package com.github.ked4ma.competitive.atcoder.awc0200

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextIntList()
    val ans = StringBuilder()
    var c = 'R'
    for (i in 0 until N) {
        ans.append(c)
        if ((i + 1) % K == 0) {
            c = if (c == 'R') 'B' else 'R'
        }
    }
    println(ans.toString())
}
