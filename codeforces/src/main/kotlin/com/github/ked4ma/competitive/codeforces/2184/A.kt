package com.github.ked4ma.competitive.codeforces.`2184`

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
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
    // 10000
    var ans = INT_INF
    for (i in 0..n / 6) {
        ans = min(ans, (n - 6 * i) % 4)
    }
    println(ans)
}
