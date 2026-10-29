package com.github.ked4ma.competitive.atcoder.awc0188

import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.max

fun main() {
    val (N, K) = nextIntList()
    val A = nextLongList()
    var n = 0L
    for (i in 0 until K - 1) {
        n += A[i]
    }
    var ans = 0L
    for (i in K - 1 until N) {
        n += A[i]
        ans = max(ans, n)
        n -= A[i - (K - 1)]
    }
    println(ans + A.sum())
}
