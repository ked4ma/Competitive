package com.github.ked4ma.competitive.atcoder.abc390

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.array.long.d2.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, X) = nextIntList()
    val VAC = times(N) {
        val (V, A, C) = nextIntList()
        Triple(V - 1, A, C)
    }
    val dp = sized2DLongArray(3, X + 1, Long.MIN_VALUE)
    dp[0][0] = 0
    dp[1][0] = 0
    dp[2][0] = 0
    for (n in range(N)) {
        val (v, a, c) = VAC[n]
        for (x in range(X).reversed()) {
            if (dp[v][x] < 0) continue
            if (x + c <= X) {
                dp[v][x + c] = max(dp[v][x + c], dp[v][x] + a)
            }
        }
    }
    val m = sized2DLongArray(3, X + 1, 0)
    for (x in 1..X) {
        for (v in range(3)) {
            m[v][x] = max(m[v][x - 1], dp[v][x])
        }
    }

    val s = sizedIntArray(3, 0)
    repeat(X) {
        val i = range(3).minBy { m[it][s[it]] }
        s[i]++
    }
    println(range(3).minOf { m[it][s[it]] })
}
