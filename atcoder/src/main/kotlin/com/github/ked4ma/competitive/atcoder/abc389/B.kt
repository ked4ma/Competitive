package com.github.ked4ma.competitive.atcoder.abc389

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    var N = nextLong()
    var ans = 1
    do {
        ans++
        N /= ans
    } while (N > 1)
    println(ans)
}
