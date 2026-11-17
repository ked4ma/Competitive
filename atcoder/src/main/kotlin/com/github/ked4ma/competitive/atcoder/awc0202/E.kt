package com.github.ked4ma.competitive.atcoder.awc0202

import com.github.ked4ma.competitive.common.array.int.d2.*
import com.github.ked4ma.competitive.common.array.int.d2.chmin.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import com.github.ked4ma.competitive.common.number.int.bit.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.abs
import kotlin.math.min

fun main() {
    val (N, M, K) = nextIntList()
    val RC = times(K) {
        val (R, C) = nextIntList()
        R to C
    }
    if (K == 0) {
        println(0)
        return
    }
    val n = 1 shl K
    val dp = sized2DIntArray(n, K, INT_INF)
    dp[0][0] = 0
    for (i in 1 until n) {
        for (k in 0 until K) {
            if (!i.bit(k)) continue
            val (r, c) = RC[k]
            val j = i xor (1 shl k)
            if (j == 0) {
                dp.chmin(i, k, abs(r - 1) + abs(c - 1))
            } else {
                for (k2 in 0 until K) {
                    if (!j.bit(k2)) continue
                    val (r2, c2) = RC[k2]
                    dp.chmin(i, k, dp[j][k2] + abs(r - r2) + abs(c - c2))
                }
            }
        }
    }
    var ans = INT_INF
    for (k in 0 until K) {
        val (r, c) = RC[k]
        ans = min(ans, dp[n - 1][k] + abs(r - 1) + abs(c - 1))
    }
    println(ans)
}
