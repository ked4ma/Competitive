package com.github.ked4ma.competitive.atcoder.abc443

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, T) = nextIntList()
    val A = ((if (N > 0) nextIntList() else listOf()) + listOf(T)).distinct()
    var t = 0
    var ans = 0
    for (a in A) {
        if (t <= a) {
            ans += a - t
            t = a + 100
        }
    }
    println(ans)
}
