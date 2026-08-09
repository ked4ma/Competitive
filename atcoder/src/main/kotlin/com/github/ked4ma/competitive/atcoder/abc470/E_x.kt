package com.github.ked4ma.competitive.atcoder.abc470

import com.github.ked4ma.competitive.common.array.double.d3.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, L) = nextIntList()
    val A = nextIntList()

    val dp = sized3DDoubleArray(L + 1, N + 1, N + 1, -1.0)
    fun f(l: Int, n: Int, b: Int): Double {
        if (dp[l][n][b] != -1.0) return dp[l][n][b]
        if (l == 0) {
            dp[l][n][b] = 0.0
            return 0.0
        }
        if (n == 0) {
            dp[l][n][b] = b.toDouble()
            return b.toDouble()
        }
        val m = 2.0 * (n + b) - b
        var res = 0.0
        if (b > 0) { // known
            val p = b.toDouble() / m
            res += p * (1.0 + f(l, n, b - 1))
        }
        // unknown
        val p = (2 * n).toDouble() / m
        // unknown + same
        run {
            val p2 = 1.0 / (m - 1)
            res += p * p2 * (1.0 + f(l, n - 1, b))
        }
        // unknown + unknown
        if (n > 1) {
            val p2 = (2 * n - 2).toDouble() / (m - 1)
            res += p * p2 * f(l - 1, n - 2, b + 2)
        }
        // unknown + known
        run {
            val p2 = b.toDouble() / (m - 1)
            if (l > 1) {
                res += p * p2 * (1.0 + f(l - 1, n - 1, b))
            }
        }

        dp[l][n][b] = res
        return res
    }
    println(f(L, N, 0) * A.sum() / N)
}
