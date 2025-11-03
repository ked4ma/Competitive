package com.github.ked4ma.competitive.atcoder.abc384

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.range.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, c1, c2) = nextList().let { (N, c1, c2) -> Triple(N.toInt(), c1[0], c2[0]) }
    val S = nextCharArray()
    for (i in range(N)) {
        if (S[i] != c1) {
            S[i] = c2
        }
    }
    println(S.concatToString())
}
