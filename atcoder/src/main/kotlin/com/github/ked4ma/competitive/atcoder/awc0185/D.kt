package com.github.ked4ma.competitive.atcoder.awc0185

import com.github.ked4ma.competitive.common.array.int.d2.*
import com.github.ked4ma.competitive.common.array.int.d2.chmax.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K, C) = nextIntList()
    val WV = times(N) {
        val (W, V) = nextIntList()
        W to V
    }
    val dp = sized2DIntArray(C + 1, K + 1)
    for (i in 0 until N) {
        val (w, v) = WV[i]
        for (k in (0 until K).reversed()) {
            for (c in (0 until C).reversed()) {
                if (c + w > C) continue
                dp.chmax(c + w, k + 1, dp[c][k] + v)
            }
        }
    }
    println(dp.maxOf { it.max() })
}
