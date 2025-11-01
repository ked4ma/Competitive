package com.github.ked4ma.competitive.atcoder.abc430

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val S = times(N) { nextCharArray() }
    val set = mutableSetOf<String>()

    for (i in 0 until N - M + 1) {
        for (j in 0 until N - M + 1) {
            val sb = StringBuilder()
            for (a in 0 until M) {
                for (b in 0 until M) {
                    sb.append(S[i + a][j + b])
                }
            }
            set.add(sb.toString())
        }
    }
    println(set.size)
}
