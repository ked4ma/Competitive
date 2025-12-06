package com.github.ked4ma.competitive.codeforces.`2173`

import com.github.ked4ma.competitive.common.debug.*
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
    val a = nextLongList()
    val b = nextLongList()
    var min = 0L
    var max = 0L
    for (i in 0 until n) {
        val x1 = max - a[i]
        val x2 = min - a[i]
        val y1 = b[i] - max
        val y2 = b[i] - min
        min = minOf(x1, x2, y1, y2)
        max = maxOf(x1, x2, y1, y2)
        _debug_println("$n: $min $max")
    }
    println(max)
}
