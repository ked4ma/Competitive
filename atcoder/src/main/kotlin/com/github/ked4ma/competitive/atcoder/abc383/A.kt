package com.github.ked4ma.competitive.atcoder.abc383

import com.github.ked4ma.competitive.common.input.default.*


// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    var t = 0
    var ans = 0
    repeat(N) {
        val (T, V) = nextIntList()
        ans = (ans - (T - t)).coerceAtLeast(0)
        ans += V
        t = T
    }
    println(ans)
}
