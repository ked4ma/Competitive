package com.github.ked4ma.competitive.codeforces.`2193`

import com.github.ked4ma.competitive.common.array.int.output.*
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
    val p = nextIntList().toIntArray()
    var l = 0
    while (l < n && p[l] == n - l) l++
    var r = l
    while (r < n && p[r] != n - l) r++
    _debug_println("$l, $r")
    while (l < r) {
        p[l] = p[r].also { p[r] = p[l] }
        l++
        r--
    }
    p.println(" ")
}
