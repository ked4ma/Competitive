package com.github.ked4ma.competitive.codeforces.`2199`

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
    val k = nextInt()
    val (a1, b1) = nextIntList()
    val (a2, b2) = nextIntList()
    _debug_println(a1 + a2)
    _debug_println(b1 + b2)
    var ac = 0
    var bc = 0
    if (a1 > b1) ac++ else bc++
    if (a2 > b2) ac++ else bc++
    val at = a1 + a2
    val bt = b1 + b2
    val ans = if (bt + k > at) {
        "YES"
    } else if (bt + k == at) {
        if (bc >= ac) "YES" else "NO"
    } else {
        "NO"
    }
    println(ans)
}
