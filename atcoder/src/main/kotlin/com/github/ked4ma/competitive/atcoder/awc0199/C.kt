package com.github.ked4ma.competitive.atcoder.awc0199

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.max

fun main() {
    val (N, C) = nextIntList()
    val A = times(N) {
        nextLong() - C
    }

    var p = -LONG_INF
    var ans = 0L
    for (i in (0 until N).reversed()) {
        p = max(p + A[i], A[i])
        ans = max(ans, p)
    }
    println(ans)
}
