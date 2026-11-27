package com.github.ked4ma.competitive.atcoder.awc0210

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.mod.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    MOD = MOD998244353
    val (N, M, X) = nextIntList()
    var dp = sizedLongArray(M)
    dp[0] = 1
    repeat(N) {
        var pre = sizedLongArray(M)
        dp = pre.also { pre = dp }
        val (A, B) = nextIntList()
        for (m in 0 until M) {
            if (pre[m] == 0L) continue
            dp[(m + A) % M] += pre[m]
            dp[(m + A) % M] %= MOD
            dp[(m - (B % M) + M) % M] += pre[m]
            dp[(m - (B % M) + M) % M] %= MOD
        }
    }
    println(dp[X])
}
