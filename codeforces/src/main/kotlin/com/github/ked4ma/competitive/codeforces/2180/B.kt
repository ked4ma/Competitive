package com.github.ked4ma.competitive.codeforces.`2180`

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
    val a = nextList()
    var s = a[0]
    for (i in 1 until n) {
        val s1 = s + a[i]
        val s2 = a[i] + s
        s = if (s1 < s2) s1 else s2
    }
    println(s)
}
