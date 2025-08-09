package com.github.ked4ma.competitive.atcoder.abc418

import com.github.ked4ma.competitive.common.array.long.d2.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val S = nextCharArray()
    val dp = sized2DLongArray(N + 1, 2, 0)
    for (i in 1..N) {
        if (S[i - 1] == '0') {
            dp[i][0] = dp[i - 1][1]
            dp[i][1] = dp[i - 1][0] + 1
        } else {
            dp[i][0] = dp[i - 1][0] + 1
            dp[i][1] = dp[i - 1][1]
        }
    }
    var ans = 0L
    for (i in 1..N) {
        ans += dp[i][0]
    }
    println(ans)
}
