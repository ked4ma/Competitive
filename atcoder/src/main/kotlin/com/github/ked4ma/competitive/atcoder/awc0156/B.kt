package com.github.ked4ma.competitive.atcoder.awc0156

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.array.long.d1.chmin.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextLongList()

    val dp = sizedLongArray(N, LONG_INF)
    dp[0] = 0
    for (i in 0 until N - 1) {
        dp.chmin(i + 1, dp[i] + max(A[i + 1] - A[i], 0))
        if (i + 2 < N) {
            dp.chmin(i + 2, dp[i] + max(A[i + 2] - A[i], 0))
        }
    }
    println(dp.last())
}
