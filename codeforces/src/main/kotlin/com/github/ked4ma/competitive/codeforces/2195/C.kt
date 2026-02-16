package com.github.ked4ma.competitive.codeforces.`2195`

import com.github.ked4ma.competitive.common.array.int.d2.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*

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
    val dp = sized2DIntArray(n + 1, 7, INT_INF)
    repeat(7) {
        dp[0][it] = 0
    }
    for (i in 0 until n) {
        val b = a[i]
        for (k in 1..6) {
            val d = if (k == b) 0 else 1
            dp[i + 1][k] = adj.getValue(k).minOf { dp[i][it] } + d
        }
    }
    _debug_println(dp)
    println(dp[n].min())
}

private val adj = mutableMapOf(
    1 to setOf(2, 3, 4, 5), // 6
    2 to setOf(1, 3, 4, 6), // 5
    3 to setOf(1, 2, 5, 6), // 4
    4 to setOf(1, 2, 5, 6), // 3
    5 to setOf(1, 3, 4, 6), // 2
    6 to setOf(2, 3, 4, 5), // 1
)
