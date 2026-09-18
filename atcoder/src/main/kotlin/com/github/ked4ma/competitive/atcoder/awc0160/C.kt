package com.github.ked4ma.competitive.atcoder.awc0160

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.array.long.d1.chmax.*
import com.github.ked4ma.competitive.common.debug._debug_println
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M, K) = nextIntList().let { (N, M, K) -> Triple(N, M, K.toLong()) }
    val H = nextLongList()
    val PR = buildMap {
        repeat(M) {
            val (p, r) = nextIntList()
            put(p - 1, r.toLong())
        }
    }

    val dp = sizedLongArray(N, -LONG_INF)
    dp[0] = K
    for (i in 0 until N - 1) {
        dp[i] -= H[i]
        if (dp[i] < 0) continue
        if (i in PR) dp[i] += PR.getValue(i)
        val h = dp[i]
        if (i + 1 < N) dp.chmax(i + 1, h)
        if (i + 2 < N) dp.chmax(i + 2, h)
    }
    var ans = dp[N - 1] - H[N - 1]
    if (ans < 0) {
        ans = -1
    } else if (N - 1 in PR) {
        ans += PR.getValue(N - 1)
    }
    println(ans)
    _debug_println(dp)
}
