package com.github.ked4ma.competitive.atcoder.abc476

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val S = next()
    val T = next()
    for (i in 0 until N) {
        if (!(S[i] == T[i] || T[i] == '*')) {
            println("No")
            return
        }
    }
    println("Yes")
}
