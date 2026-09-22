package com.github.ked4ma.competitive.codeforces.`2266`

import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.abs
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private fun solve() {
    val (a, b, c) = nextLongList()
    println(max(abs(a + c - b), abs(a - b)))
}
