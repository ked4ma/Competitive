package com.github.ked4ma.competitive.atcoder.awc0154

import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.abs

fun main() {
    val (N, P) = nextIntList()
    var ans = 0.0
    repeat(N) {
        val (X, V) = nextIntList()
        if (X == P) return@repeat
        ans += V.toDouble() / abs(X - P)
    }
    println(ans)
}
