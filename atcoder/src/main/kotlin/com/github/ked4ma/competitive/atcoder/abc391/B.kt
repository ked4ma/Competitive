package com.github.ked4ma.competitive.atcoder.abc391

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*
import com.github.ked4ma.competitive.common.repeat.range.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val S = times(N) { nextCharArray() }
    val T = times(M) { nextCharArray() }

    for (a in 0..N - M) {
        for (b in 0..N - M) {
            if (range(M).all { i -> range(M).all { j -> S[a + i][b + j] == T[i][j] } }) {
                println("${a + 1} ${b + 1}")
                return
            }
        }
    }
}
