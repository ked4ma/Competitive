package com.github.ked4ma.competitive.atcoder.abc413

import com.github.ked4ma.competitive.common.debug._debug_println
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private fun solve() {
    val N = nextInt()
    val P = nextIntList()
    var list = P.windowed(2, 2).map { it.sorted() }
    _debug_println(list.size)
    repeat(N - 1) {
        list = list.windowed(2, 2).map { it.sortedBy { it[0] }.flatten() }
    }
    println(list.joinToString(" ") { it.joinToString(" ") })
}
