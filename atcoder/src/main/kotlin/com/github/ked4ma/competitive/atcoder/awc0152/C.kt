package com.github.ked4ma.competitive.atcoder.awc0152

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.mod.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    MOD = MOD998244353
    val (N, K) = nextIntList()
    val A = nextIntList()
    var dp = sizedLongArray(K)
    dp[0] = 1
    for (i in 0 until N) {
        val a = A[i]
        var pre = sizedLongArray(K)
        dp = pre.also { pre = dp }
        for (k in 0 until K) {
            if (pre[k] == 0L) continue
            // not selected
            dp[k] += pre[k]
            dp[k] %= MOD
            // selected
            dp[(k + a) % K] += pre[k]
            dp[(k + a) % K] %= MOD
        }
    }
    println(dp[0] - 1)
}
