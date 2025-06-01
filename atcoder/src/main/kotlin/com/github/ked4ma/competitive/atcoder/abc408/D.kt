package com.github.ked4ma.competitive.atcoder.abc408

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

fun solve() {
    val N = nextInt()
    val S = nextCharArray()
    val dp = sizedIntArray(3, INT_INF)
    dp[0] = 0
    for (i in range(N)) {
        val c = S[i]
        // 1 -> 0
        dp[2] = min(dp[2], dp[1]) + if (c == '1') 1 else 0
        // 1
        dp[1] = min(dp[1], dp[0]) + if (c == '1') 0 else 1
        // 0
        dp[0] += if (c == '1') 1 else 0
    }
    println(dp.min())

}
