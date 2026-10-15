package com.github.ked4ma.competitive.atcoder.awc0179

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.mod.*

fun main() {
    MOD = MOD998244353
    val N = nextInt()
    val S = nextCharArray()

    var dp = sizedLongArray(2, 0)
    dp[1] = 1
    for (i in 0 until N) {
        var pre = sizedLongArray(2, 0L)
        dp = pre.also { pre = dp }
        val c = S[i]
        when (c) {
            'A' -> {
                dp[0] += pre[1]
                dp[0] %= MOD
            }

            'B' -> {
                dp[1] += pre[0]
                dp[1] %= MOD
                dp[1] += pre[1]
                dp[1] %= MOD
            }

            'C' -> {
                dp[0] += pre[1]
                dp[0] %= MOD
                dp[1] += pre[0]
                dp[1] %= MOD
                dp[1] += pre[1]
                dp[1] %= MOD
            }
        }
        _debug_println(dp)
    }
    println(dp.sum() % MOD)
}
