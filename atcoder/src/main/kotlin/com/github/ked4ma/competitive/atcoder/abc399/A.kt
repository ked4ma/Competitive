package com.github.ked4ma.competitive.atcoder.abc399

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val S = nextCharArray()
    val T = nextCharArray()
    var ans = 0
    for (i in range(N)) {
        if (S[i] != T[i]) ans++
    }
    println(ans)
}
