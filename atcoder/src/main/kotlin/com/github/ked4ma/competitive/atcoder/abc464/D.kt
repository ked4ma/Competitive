package com.github.ked4ma.competitive.atcoder.abc464

import com.github.ked4ma.competitive.common.array.long.d2.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private fun solve() {
    val N = nextInt()
    val S = nextCharArray()
    val X = nextLongList()
    val Y = nextLongList()
    val dp = sized2DLongArray(N, 2, -LONG_INF)
    when (S[0]) {
        'S' -> {
            dp[0][0] = 0
            dp[0][1] = -X[0]
        }

        'R' -> {
            dp[0][0] = -X[0]
            dp[0][1] = 0
        }
    }
    for (i in 1 until N) {
        when (S[i]) {
            'S' -> {
                // S
                dp[i][0] = max(
                    // S -> S
                    dp[i - 1][0],
                    // R -> S
                    dp[i - 1][1] + Y[i - 1],
                )
                // R
                dp[i][1] = max(
                    // S -> R
                    dp[i - 1][0] - X[i],
                    // R -> R
                    dp[i - 1][1] - X[i],
                )
            }

            'R' -> {
                // S
                dp[i][0] = max(
                    // S -> S
                    dp[i - 1][0] - X[i],
                    // R -> S
                    dp[i - 1][1] - X[i] + Y[i - 1],
                )
                // R
                dp[i][1] = max(
                    // S -> R
                    dp[i - 1][0],
                    // R -> R
                    dp[i - 1][1]
                )
            }
        }
    }
    println(dp[N - 1].max())
}
