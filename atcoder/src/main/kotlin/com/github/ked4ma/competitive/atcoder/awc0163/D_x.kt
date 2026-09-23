package com.github.ked4ma.competitive.atcoder.awc0163

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.mod.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]

// passed. but timed out.
fun main() {
    MOD = MOD998244353
    val (N, P, Q, M) = nextIntList()
    val LR = times(N) {
        val (L, R) = nextIntList()
        L to R
    }.toTypedArray()
    val dp = Array(N + 1) { Array(P + 1) { Array(Q + 1) { LongArray(121) } } }
    dp[0][0][0][60] = 1
    fun f(s: Int = 0) {
        for (i in s until N) {
            dp[i + 1] = Array(P + 1) { Array(Q + 1) { LongArray(121) } }
            val (l, r) = LR[i]
            for (p in 0..P) {
                for (q in 0..Q) {
                    for (n in 0 until 121) {
                        if (dp[i][p][q][n] == 0L) continue
                        dp[i + 1][p][q][n] += dp[i][p][q][n]
                        dp[i + 1][p][q][n] %= MOD
                        // p
                        if (p < P) {
                            for (x in l..r) {
                                if (n + x in 0 until 121) {
                                    dp[i + 1][p + 1][q][n + x] += dp[i][p][q][n]
                                    dp[i + 1][p + 1][q][n + x] %= MOD
                                }
                            }
                        }
                        // q
                        if (q < Q) {
                            for (x in l..r) {
                                if (n - x in 0 until 121) {
                                    dp[i + 1][p][q + 1][n - x] += dp[i][p][q][n]
                                    dp[i + 1][p][q + 1][n - x] %= MOD
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    f()
//    _debug_println(N == 3) { dp[N][1][1][1][1] }
//    _debug_println(N == 3) { dp[N][1][1][2][2] }
//    _debug_println(N == 3) { dp[N][1][1][3][3] }
//    _debug_println("=====")
    repeat(M) {
        val (x, a, b) = nextIntList()
        LR[x - 1] = a to b
        f(x - 1)
        println(dp[N][P][Q][60])
//        for (x in 1..min(20 * P, 20 * Q)) {
//            ans += dp[N][P][Q][x]
//            ans %= MOD
//            _debug_println(N == 3) { dp[N][1][1][x][x] }
//        }
//        println(ans)
    }
}
