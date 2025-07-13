package com.github.ked4ma.competitive.atcoder.abc414

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, L, R) = nextIntList()
    var ans = 0
    repeat(N) {
        val (X, Y) = nextIntList()
        if (X <= L && R <= Y) ans++
    }
    println(ans)
}
