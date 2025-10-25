package com.github.ked4ma.competitive.atcoder.abc428

import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private fun solve() {
    val (C, D) = nextLongList()
    val ans = g(C, C + D) - g(C, C)
    println(ans)
}

private fun g(c: Long, r: Long): Long {
    var res = 0L
    var l = 1L
    while (true) {
        val base = c * l * 10
        val nl = base + l
        var nr = base + (l * 10 - 1)
        nr = min(nr, base + r)
        if (nr < nl) return res
        res += s(nl, nr)
        l *= 10
    }
}

private fun s(l: Long, r: Long): Long {
    return s(r) - s(l - 1)
}

private fun s(r: Long): Long = sqrtl(r)

private fun sqrtl(n: Long): Long {
    var l = 0L
    var r = Int.MAX_VALUE.toLong()
    while (l + 1 < r) {
        val m = (l + r) / 2
        if (m * m > n) {
            r = m
        } else {
            l = m
        }
    }
    return l
}
