package com.github.ked4ma.competitive.atcoder.awc0185

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (A, B, C) = nextIntList()
    var ans = 1
    var n = A
    if (n < B) {
        ans = 2
        n = B
    }
    if (n < C) {
        ans = 3
    }
    println(ans)
}
