package com.github.ked4ma.competitive.codeforces.`2266`

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private fun solve() {
    val n = nextInt()
    val a = nextIntList()
    println(n - a.min())
}
