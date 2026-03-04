package com.github.ked4ma.competitive.codeforces.`2199`

import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.max
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val t = nextInt()
    repeat(t) {
        solve()
    }
}

private fun solve() {
    var (a, b, c, d) = nextIntList()
    var ans = 0
    if (max(a, b) < min(c, d)) {
        ans += max(a, b) - min(a, b)
        max(a, b).let {
            a = it
            b = it
        }
    }
    if (a == b) {
        val e = min(c, d)
        ans += e - a
        a = e
        b = e
    }
    ans += c - a
    ans += d - b
    println(ans)
}
