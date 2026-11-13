package com.github.ked4ma.competitive.atcoder.awc0200

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.array.long.d1.chmax.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val A = nextIntList()
    val BC = times(N - 1) {
        val (B, C) = nextIntList()
        B to C.toLong()
    }
    if (A[0] > M) {
        println(0)
        return
    }
    var dp = sizedLongArray(M + 1, -LONG_INF)
    dp[M - A[0]] = 0
    for (i in 0 until N - 1) {
        var pre = sizedLongArray(M + 1, -LONG_INF)
        dp = pre.also { pre = dp }
        val (b, c) = BC[i]
        val a = A[i + 1]
        for (m in 0..M) {
            // b,a
            val j = min(m + b, M) - a
            if (j >= 0) {
                dp.chmax(j, pre[m])
            }
            // c,a
            val k = m - a
            if (k >= 0) {
                dp.chmax(k, pre[m] + c)
            }
        }
    }
    println(dp.max())
}
