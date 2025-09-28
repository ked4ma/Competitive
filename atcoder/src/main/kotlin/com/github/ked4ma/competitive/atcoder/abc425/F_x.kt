package com.github.ked4ma.competitive.atcoder.abc425

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.mod.*
import com.github.ked4ma.competitive.common.number.int.bit.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val MOD = MOD998244353
    val N = nextInt()
    val T = next()
    val N2 = 1 shl N

    val dp = sizedLongArray(N2, 0)
    dp[N2 - 1] = 1
    for (s in N2 - 1 downTo 0) {
        var pre = '-'
        for (i in 0 until N) {
            if (s.bit(i)) {
                if (pre != T[i]) {
                    dp[s xor (1 shl i)] += dp[s]
                    dp[s xor (1 shl i)] %= MOD
                }
                pre = T[i]
            }
        }
    }
    println(dp[0])
}
