package com.github.ked4ma.competitive.atcoder.awc0200

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.array.long.d1.chmax.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextIntList()
    val A = nextLongList().sorted()
    _debug_println(A)
    if (N < K) {
        println(-1)
        return
    }
    val dp = sizedLongArray(N, -LONG_INF)
    dp[K - 1] = 0
    for (i in 0 until N - 1) {
        if (dp[i] >= 0 && i + K < N) {
            dp.chmax(i + K, dp[i] + (A[i + 1] - A[i]))
        }
        dp.chmax(i + 1, dp[i])
    }
    println(A.last() - A.first() - dp.max())
    _debug_println(dp)
}
