package com.github.ked4ma.competitive.atcoder.abc443

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextLongList()
    var ans = 0L
    while ((ans + 2 * N) * (ans + 1) / 2 < K) ans++
    println(ans)
}
