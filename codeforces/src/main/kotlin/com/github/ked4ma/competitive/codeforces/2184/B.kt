package com.github.ked4ma.competitive.codeforces.`2184`

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val t = nextInt()
    repeat(t) {
        solve()
    }
}

private fun solve() {
    val (s, k, m) = nextIntList()
    if (s <= k) {
        val n = m % k
        println(max(s - n, 0))
        return
    }
    val a = m / k
    _debug_println(a)
    val b = m % k
    _debug_println(b)
    val c = if (a % 2 == 0) s else k
    _debug_println(c)
    println(max(c - b, 0))
}
