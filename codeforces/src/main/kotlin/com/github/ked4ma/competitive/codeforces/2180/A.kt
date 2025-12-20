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
    val (l, a, b) = nextIntList()
    val set = mutableSetOf<Int>()
    var x = a
    while (x !in set) {
        set.add(x)
        x = (x + b) % l
    }
    println(set.max())
}
