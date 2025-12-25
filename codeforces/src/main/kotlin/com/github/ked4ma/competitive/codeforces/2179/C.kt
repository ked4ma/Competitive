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
    val n = nextInt()
    val a = nextIntList().sorted()
    println(if (a[0] * 2 <= a[1]) a[1] - a[0] else a[0])
}
