package com.github.ked4ma.competitive.atcoder.abc441

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val S = next().toSet()
    val T = next().toSet()
    val Q = nextInt()
    repeat(Q) {
        val w = next().toSet()
        val t = w.all { it in S }
        val a = w.all { it in T }
        println(
            if (t && !a) {
                "Takahashi"
            } else if (!t && a) {
                "Aoki"
            } else {
                "Unknown"
            }
        )
    }
}
