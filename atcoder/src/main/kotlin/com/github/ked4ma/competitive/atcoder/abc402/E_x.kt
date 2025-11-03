package com.github.ked4ma.competitive.atcoder.abc402

import com.github.ked4ma.competitive.common.array.double.d2.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.int.bit.*
import com.github.ked4ma.competitive.common.repeat.*
import com.github.ked4ma.competitive.common.repeat.range.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, X) = nextIntList()
    val SCP = times(N) {
        nextIntList().let { (S, C, P) -> Triple(S, C, P / 100.0) }
    }
    val N2 = 1 shl N
    val dp = sized2DDoubleArray(X + 1, N2, 0.0)
    for (i in range(X + 1)) {
        for (s in range(N2)) {
            for (j in range(N)) {
                if (s.bit(j)) continue
                val (score, c, p) = SCP[j]
                if (c > i) continue
                val now = dp[i - c][s] * (1 - p) + (dp[i - c][s or (1 shl j)] + score) * p
                dp[i][s] = max(dp[i][s], now)
            }
        }
    }
    println("%.10f".format(dp[X][0]))
}
