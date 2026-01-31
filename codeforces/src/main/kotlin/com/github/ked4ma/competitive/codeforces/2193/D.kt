package com.github.ked4ma.competitive.codeforces.`2193`

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.long.bound.*
import com.github.ked4ma.competitive.common.list.long.cumlative.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val t = nextInt()
    repeat(t) {
        solve()
    }
}

private fun solve() {
    val n = nextLong()
    val a = nextLongList().sorted()
    val b = nextLongList()
    val bCum = b.cumulativeSum()
    var i = 0
    var ans = 0L
    for (x in a.distinct()) {
        while (i < n && a[i] < x) i++
        ans = max(ans, x * (bCum.upperBound(n - i) - 1))
    }
    println(ans)
}
