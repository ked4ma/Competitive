package com.github.ked4ma.competitive.atcoder.abc442

import com.github.ked4ma.competitive.common.array.int.d2.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val S = times(N) {
        nextCharArray()
    }.asReversed()
    val dp = sized2DIntArray(N + 1, N + 1, INT_INF)
    dp[0][0] = 0

    val cost_r = sized2DIntArray(N, N + 1, 0)
    for (i in 0 until N) {
        for (j in 0 until N) {
            cost_r[i][j + 1] = cost_r[i][j] + if (S[i][j] == '#') 1 else 0
        }
    }
    _debug_println("==== row")
    _debug_println(cost_r)
    val cost_c = sized2DIntArray(N + 1, N, 0)
    for (i in 0 until N) {
        for (j in 0 until N) {
            cost_c[i + 1][j] = cost_c[i][j] + if (S[i][j] == '.') 1 else 0
        }
    }
    _debug_println("==== col")
    _debug_println(cost_c)

    for (i in 0..N) {
        for (j in 0..N) {
            if (i < N) {
                dp[i + 1][j] = min(dp[i + 1][j], dp[i][j] + cost_r[i][j])
            }
            if (j < N) {
                dp[i][j + 1] = min(dp[i][j + 1], dp[i][j] + cost_c[i][j])
            }
        }
    }
    println(dp[N][N])
}
