package com.github.ked4ma.competitive.atcoder.abc416

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.long.d2.*
import com.github.ked4ma.competitive.common.array.long.d3.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextIntList()
    val A = nextLongList()
    val G = sizedArray(N) { mutableListOf<Int>() }
    repeat(N - 1) {
        val (u, v) = nextIntList().map { it - 1 }
        G[u].add(v)
        G[v].add(u)
    }

    val dp = sized3DLongArray(N, K + 1, 2, 0)
    fun f(u: Int, p: Int = -1) {
        val dp2 = sized2DLongArray(K + 1, 3, 0)
        for (v in G[u]) {
            if (v == p) continue
            f(v, u)
            for (i in K downTo 0) {
                for (j in 2 downTo 0) {
                    for (ni in 0 until K + 1) {
                        if (i + ni > K) break
                        for (nj in 0 until 2) {
                            if (j + nj > 2) break
                            dp2[i + ni][j + nj] = max(dp2[i + ni][j + nj], dp2[i][j] + dp[v][ni][nj])
                        }
                    }
                }
            }
        }
        for (i in range(K + 1)) {
            dp[u][i][0] = max(dp[u][i][0], dp2[i][0])
            dp[u][i][1] = max(dp[u][i][1], dp2[i][1] + A[u])
            if (i < K) {
                dp[u][i + 1][0] = max(dp[u][i + 1][0], dp2[i][2] + A[u])
            }
        }
    }
    f(0)
    println(dp[0][K][0])
}
