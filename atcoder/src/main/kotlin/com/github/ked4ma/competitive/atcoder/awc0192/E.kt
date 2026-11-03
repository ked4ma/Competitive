package com.github.ked4ma.competitive.atcoder.awc0192

import com.github.ked4ma.competitive.common.array.long.d3.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.max
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextIntList()
    val LR = times(N) {
        val (X, R) = nextLongList()
        X - R to X + R
    }.sortedBy { it.first }
    val dp = sized3DLongArray(N + 1, N + 1, K + 1, -LONG_INF)
    dp[0][0][0] = -LONG_INF + 1
    for (i in 0 until N) {
        val (l, r) = LR[i]
        for (j in 0..i) {
            for (k in 0..K) {
                if (dp[i][j][k] == -LONG_INF) continue
                dp[i + 1][j][k] = max(dp[i + 1][j][k], dp[i][j][k])
                // select
                if (l <= dp[i][j][k]) {
                    dp[i + 1][j + 1][k] = max(dp[i + 1][j + 1][k], min(dp[i][j][k], r))
                }
                if (k < K) {
                    dp[i + 1][j + 1][k + 1] = max(dp[i + 1][j + 1][k + 1], r)
                }
            }
        }
    }
    var ans = 0
    for (j in 0..N) {
        for (k in 0..K) {
            if (dp[N][j][k] > -LONG_INF) ans = max(ans, j)
        }
    }
    println(ans)
}
