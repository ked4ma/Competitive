package com.github.ked4ma.competitive.atcoder.awc0173

import com.github.ked4ma.competitive.common.array.any.d3.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*

fun main() {
    val (N, K) = nextIntList()
    val A = nextLongList().map { it.toBigInteger() }
    val dp = sized3DArray(N + 1, N + 1, K + 1) { 0.toBigInteger() }
    for (i in 0 until N) {
        for (j in i + 1..N) {
            dp[i][j][0] = dp[i][j - 1][0] + A[j - 1]
        }
    }

    for (m in 2 ..N) {
        for (i in 0..N - m) {
            val j = i + m
            for (s in i + 1 until j) {
                for (k in K downTo 0) {
                    for (k2 in 0..k) {
                        dp[i][j][k] = maxOf(dp[i][j][k], dp[i][s][k2] + dp[s][j][k - k2])
                        if (k < K) {
                            dp[i][j][k + 1] =
                                maxOf(dp[i][j][k + 1], (dp[i][s][k2] + dp[s][j][k - k2]) * 2.toBigInteger())
                        }
                    }
                }
            }
        }
    }
    println(dp[0][N].max())
}
