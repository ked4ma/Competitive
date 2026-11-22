package com.github.ked4ma.competitive.atcoder.abc485

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val S = times(N) { nextCharArray() }
    for (i in 0 until N) {
        val s = S[i]
        if (s.all { it == 'x' }) {
            println("Faucet ${i + 1}")
            return
        }
    }
    for (i in 0 until M) {
        if ((0 until N).all { S[it][i] == 'x' }) {
            println("Drain ${i + 1}")
            return
        }
    }
}
