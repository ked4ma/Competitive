package com.github.ked4ma.competitive.codeforces.`2179`

import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.abs
import kotlin.math.min

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
    val sum = a.windowed(2, 1).sumOf { (l, r) -> abs(l - r) }
    var ans = min(sum - abs(a[0] - a[1]), sum - abs(a[n - 2] - a[n - 1]))
    for (i in 1 until n - 1) {
        ans = min(ans, sum - abs(a[i - 1] - a[i]) - abs(a[i] - a[i + 1]) + abs(a[i - 1] - a[i + 1]))
    }
    println(ans)
}
