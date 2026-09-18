package com.github.ked4ma.competitive.atcoder.awc0159

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import com.github.ked4ma.competitive.common.number.int.bit.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.min

fun main() {
    val (N, M, K) = nextIntList()
    val c = times(M) {
        val list = nextIntList()
        var n = 0
        for (i in 1..list[0]) {
            n = n or (1 shl (list[i] - 1))
        }
        n
    }
    c.forEach { _debug_println(it.toString(2)) }
    if (K == 0) {
        println(0)
        return
    }
    var ans = INT_INF
    val dp = sizedIntArray(1 shl M)
    for (i in 1 until (1 shl M)) {
        var pi = 0
        for (j in 0 until M) {
            if (i.bit(j)) pi = j
        }
        val p = i xor (1 shl pi)
        dp[i] = dp[p] xor c[pi]
        if (dp[i].countOneBits() == K) ans = min(ans, i.countOneBits())
    }
    if (ans == INT_INF) {
        ans = -1
    }
    println(ans)
    _debug_println(M == 7) { dp[1 shl 3].toString(2) }
}
