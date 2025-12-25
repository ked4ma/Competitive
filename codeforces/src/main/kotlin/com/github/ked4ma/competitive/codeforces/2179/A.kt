package com.github.ked4ma.competitive.codeforces.`2179`

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val t = nextInt()
    repeat(t) {
        solve()
    }
}

private fun solve() {
    val (k, x) = nextIntList()
    println(k * x + 1)
}
