package com.github.ked4ma.competitive.codeforces.`2088`

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val t = nextInt()
    repeat(t) {
        solve()
    }
}

private fun solve() {
    val (n, x, y) = nextLongList()
    val a = nextLongList().sorted()
    val total = a.sum()
    var l = n.toInt()
    var r = n.toInt() - 1
    var ans = 0L
    for (i in range(n.toInt() - 1)) {
        val rem = total - a[i]
        val left = rem - y
        val right = rem - x
        _debug_println("left:right $left:$right")
        while (l - 1 >= 0 && a[l - 1] >= left) l--
        while (r >= 0 && a[r] > right) r--
        _debug_println("$l $r")
        if (max(l, i + 1) <= r) {
            ans += r - max(l, i + 1) + 1
        }
    }
    println(ans)
}
