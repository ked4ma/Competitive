package com.github.ked4ma.competitive.codeforces.`2182`

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
    val s = next()
    if (s.contains("2026")) {
        println(0)
        return
    }
    if (!s.contains("2025")) {
        println(0)
        return
    }
    println(1)
}
