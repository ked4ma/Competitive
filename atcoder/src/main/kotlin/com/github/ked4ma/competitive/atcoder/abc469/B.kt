package com.github.ked4ma.competitive.atcoder.abc469

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val S = next()
    var ans = 0
    for (i in 0 until N) {
        if (S[i] == 'o') continue
        val l = i - 1 < 0 || S[i - 1] == 'x'
        val r = i + 1 >= N || S[i + 1] == 'x'
        if (l && r) ans++
    }
    println(ans)
}
