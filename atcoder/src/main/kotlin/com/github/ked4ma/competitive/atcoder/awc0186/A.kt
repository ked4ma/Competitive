package com.github.ked4ma.competitive.atcoder.awc0186

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList()
    var ans = 0
    for (a in A) {
        if ((a - 1) % 2 == 0) ans++
    }
    println(ans)
}
