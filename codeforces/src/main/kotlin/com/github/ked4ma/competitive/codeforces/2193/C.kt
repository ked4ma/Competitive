package com.github.ked4ma.competitive.codeforces.`2193`

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.array.long.output.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val t = nextInt()
    repeat(t) {
        solve()
    }
}

private fun solve() {
    val (n, q) = nextIntList()
    val a = nextLongList().toLongArray()
    val b = nextLongList().toLongArray()
    a[n - 1] = max(a[n - 1], b[n - 1])
    for (i in (0 until n - 1).reversed()) {
        a[i] = max(a[i], b[i])
        a[i] = max(a[i], a[i + 1])
    }
    val c = sizedLongArray(n + 1)
    for (i in 0 until n) {
        c[i + 1] = c[i] + a[i]
    }
    _debug_println(a)
    _debug_println(c)
    val ans = sizedLongArray(q)
    repeat(q) { i ->
        val (l, r) = nextIntList()
        ans[i] = c[r] - c[l - 1]
    }
    ans.println(" ")
}
