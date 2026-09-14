package com.github.ked4ma.competitive.atcoder.awc0156

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.array.long.d1.bitset.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.div.ceil.*
import com.github.ked4ma.competitive.common.number.long.bit.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = times(N) { nextInt() }.sorted()
    _debug_println(A)

    var dp = sizedLongArray(100_010.ceilDiv(64))
    dp[0] = 1
    for (i in 0 until N) {
        val a = A[i]
        dp = dp orShl a
    }
    val S = A.sum()
    for (i in S / 2 downTo 0) {
        val j = i / 64
        val k = i % 64
        if (dp[j].bit(k)) {
            println(i)
            return
        }
    }
}
