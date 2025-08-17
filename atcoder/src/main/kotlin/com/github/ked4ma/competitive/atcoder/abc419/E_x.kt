package com.github.ked4ma.competitive.atcoder.abc419

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.array.int.d2.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M, L) = nextIntList()
    val A = nextIntList()

    val cost = sized2DIntArray(L, M, 0)
    for (i in 0 until N) {
        val g = i % L
        for (j in 0 until M) {
            cost[g][(A[i] + j) % M] += j
        }
    }

    var dp = sizedIntArray(M, INT_INF)
    dp[0] = 0
    for (i in 0 until L) {
        val next = sizedIntArray(M, INT_INF)
        for (j in 0 until M) {
            for (k in 0 until M) {
                next[(j + k) % M] = min(next[(j + k) % M], dp[j] + cost[i][k])
            }
        }
        dp = next
    }
    println(dp[0])
}
