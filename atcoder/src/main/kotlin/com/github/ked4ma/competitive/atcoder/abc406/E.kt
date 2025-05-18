package com.github.ked4ma.competitive.atcoder.abc406

import com.github.ked4ma.competitive.common.array.long.d3.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.mod.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

fun solve() {
    val MOD = MOD998244353
    val (N, K) = nextLongList().let { (N, K) -> N.toString(2) to K.toInt() }
    val M = N.length
    val dp = sized3DLongArray(M + 1, K + 1, 2, 0)
    val dp2 = sized3DLongArray(M + 1, K + 1, 2, 0)
    dp[0][0][0] = 1
    for (i in range(M)) {
        val b = N[i] - '0'
        for (k in range(K + 1)) {
            for (isless in range(2)) {
                for (j in range(2)) {
                    if (k == K && j == 1) continue
                    val n = ((1L shl (M - 1 - i)) * j) % MOD
                    if (j < b) {
                        dp[i + 1][k + j][1] += dp[i][k][isless]
                        dp[i + 1][k + j][1] %= MOD
                        dp2[i + 1][k + j][1] += (n * dp[i][k][isless]) % MOD
                        dp2[i + 1][k + j][1] += dp2[i][k][isless]
                        dp2[i + 1][k + j][1] %= MOD
                    } else if (b == j) {
                        dp[i + 1][k + j][isless] += dp[i][k][isless]
                        dp[i + 1][k + j][isless] %= MOD
                        dp2[i + 1][k + j][isless] += (n * dp[i][k][isless]) % MOD
                        dp2[i + 1][k + j][isless] += dp2[i][k][isless]
                        dp2[i + 1][k + j][isless] %= MOD
                    } else {
                        if (isless == 1) {
                            dp[i + 1][k + j][isless] += dp[i][k][isless]
                            dp[i + 1][k + j][isless] %= MOD
                            dp2[i + 1][k + j][isless] += (n * dp[i][k][isless]) % MOD
                            dp2[i + 1][k + j][isless] += dp2[i][k][isless]
                            dp2[i + 1][k + j][isless] %= MOD
                        }
                    }
                }
            }
        }
    }
    println(dp2[M][K][0].plusMod(dp2[M][K][1], MOD))
}
