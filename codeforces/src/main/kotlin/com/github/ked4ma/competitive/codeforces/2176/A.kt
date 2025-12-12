package com.github.ked4ma.competitive.codeforces.`2176`

import com.github.ked4ma.competitive.common.array.int.d1.*
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
    val n = nextInt()
    val a = nextIntList()
    val b = sizedIntArray(n + 1, 0)
    for (i in 0 until n) {
        b[i + 1] = max(b[i], a[i])
    }
    _debug_println(b)
    var ans = 0
    for (i in (0 until n).reversed()) {
        if (a[i] < b[i]) ans++
    }
    println(ans)
}
