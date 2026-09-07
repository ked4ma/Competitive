package com.github.ked4ma.competitive.atcoder.awc0151

import com.github.ked4ma.competitive.common.array.long.d2.*
import com.github.ked4ma.competitive.common.array.long.d2.chmax.*
import com.github.ked4ma.competitive.common.debug._debug_println
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M, K, B) = nextIntList()
    // s + d - 1 <= t
    // s <= t - d + 1

    val data = times(N) {
        val (d, v, t) = nextIntList()
        Triple(d, v.toLong(), t)
    }.sortedBy { it.third }

    val dp = sized2DLongArray(N + 1, M + 1, -LONG_INF)
    dp[0][0] = 0
    for (i in 0 until N) {
        val (D, V, T) = data[i]
        for (k in i downTo 0) {
            for (t in 0..T - D) {
                dp.chmax(k + 1, t + D, dp[k][t] + V)
            }
        }
    }
    _debug_println(N == 3) {dp}

    var ans = 0L
    for (k in 0..N) {
        for (t in 0..M) {
            ans = max(ans, dp[k][t] + if (k >= K) B else 0)
        }
    }
    println(ans)
}
