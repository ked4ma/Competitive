package com.github.ked4ma.competitive.atcoder.abc456

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.debug._debug_println
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.mod.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    MOD = MOD998244353
    val S = nextCharArray()
    val n = S.size

    var dp = sizedLongArray(3)
    for (i in 0 until n) {
        val c = S[i]
        val j = c - 'a'
        var pre = dp.copyOf()
        val sum = pre.sum()
        dp = pre.also { pre = dp }
        // first
        dp[j] += 1
        dp[j] %= MOD
        dp[j] += sum - pre[j]
        dp[j] %= MOD
    }
    _debug_println(dp)
    var ans = 0L
    for (n in dp) {
        ans += n
        ans %= MOD
    }
    println(ans)
}
