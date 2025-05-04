package com.github.ked4ma.competitive.atcoder.abc404

import com.github.ked4ma.competitive.common.array.double.d2.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.max
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, T, M, K) = nextIntList()
    val dp = sized2DDoubleArray(T + 1, K + 1, 0.0)
    dp[T][K] = 1.0

    for (ti in range(T).reversed()) {
        for (kj in range(K + 1)) {
            var now = 0.0
            val dp2 = sized2DDoubleArray(M + 1, M + 1, 0.0)
            for (i in range(M)) {
                for (j in range(M + 1)) {
                    var c = 1
                    while (j + c <= M) {
                        dp2[i + 1][j + c] = max(
                            dp2[i + 1][j + c],
                            dp2[i][j] + dp[ti + 1][min(K, kj + c)]
                        )
                        c++
                    }
                }
            }
            for (i in range(M + 1)) {
                if (i > N) break
                var x = dp2[i][M]
                x += dp[ti + 1][kj] * (N - i)
                now = max(now, x)
            }
            dp[ti][kj] = now / N
        }
    }
    println("%.10f".format(dp[0][0]))
}
