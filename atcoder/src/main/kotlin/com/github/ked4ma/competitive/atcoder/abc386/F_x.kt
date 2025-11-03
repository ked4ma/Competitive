package com.github.ked4ma.competitive.atcoder.abc386

import com.github.ked4ma.competitive.common.array.int.d2.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.range.*
import kotlin.math.abs
import kotlin.math.min


// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val K = nextInt()
    val S = next()
    val T = next()

    if (abs(S.length - T.length) > K) {
        println("No")
        return
    }

    val dp = sized2DIntArray(S.length + 1, 2 * K + 1, Int.MAX_VALUE / 2)
    dp[0][K] = 0
    for (i in range(S.length + 1)) {
        for (dj in 0..2 * K) {
            val j = i + dj - K
            if (j < 0) continue
            if (j > T.length) break
            if (i > 0 && dj < 2 * K) { // del
                dp[i][dj] = min(dp[i][dj], dp[i - 1][dj + 1] + 1)
            }
            if (j > 0 && dj > 0) { // ins
                dp[i][dj] = min(dp[i][dj], dp[i][dj - 1] + 1)
            }
            if (i > 0 && j > 0) { // upd
                if (S[i - 1] == T[j - 1]) {
                    dp[i][dj] = min(dp[i][dj], dp[i - 1][dj])
                } else {
                    dp[i][dj] = min(dp[i][dj], dp[i - 1][dj] + 1)
                }
            }
        }
    }
    _debug_println(dp[S.length][K + T.length - S.length])
    println(if (dp[S.length][K + T.length - S.length] <= K) "Yes" else "No")
}
