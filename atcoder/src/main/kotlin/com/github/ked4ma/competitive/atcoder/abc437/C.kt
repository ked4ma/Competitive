package com.github.ked4ma.competitive.atcoder.abc437

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private fun solve() {
    val N = nextInt()
    val WP = times(N) {
        val (W, P) = nextIntList()
        W to P
    }.sortedByDescending { it.first + it.second }
    var w = WP.sumOf { it.first.toLong() }
    var p = 0L
    var ans = N
    var i = 0
    while (i < N && p < w) {
        w -= WP[i].first
        p += WP[i].second
        i++
        ans--
    }
    println(ans)
}
