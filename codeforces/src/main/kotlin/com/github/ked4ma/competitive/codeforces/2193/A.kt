package com.github.ked4ma.competitive.codeforces.`2193`

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val t = nextInt()
    repeat(t) {
        solve()
    }
}

private fun solve() {
    val (n, s, x) = nextIntList()
    val a = nextIntList()
    val sum = a.sum()
    if (sum > s) {
        println("NO")
        return
    }
    println(if ((s - sum) % x == 0) "YES" else "NO")
}
