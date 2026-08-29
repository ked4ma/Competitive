package com.github.ked4ma.competitive.atcoder.abc473

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.array.int.d1.chmax.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextIntList()
    val A = nextIntList()

    val p = sizedIntArray(N + 1)
    for (i in 0 until N) {
        p[i + 1] = (p[i] + A[i]) % K
    }
    _debug_println(p)

    val prev = mutableMapOf<Int, Int>()
    val dp = sizedIntArray(N + 1)
    prev[p[0]] = dp[0]

    for (i in 0 until N) {
        dp[i + 1] = dp[i]

        if (p[i + 1] in prev) {
            dp.chmax(i + 1, prev.getValue(p[i + 1]) + 1)
        }
        prev[p[i + 1]] = max(prev.getOrDefault(p[i + 1], 0), dp[i + 1])
        _debug_println("${dp.joinToString(" ")}: $prev")
    }
    println(dp.last())
}
