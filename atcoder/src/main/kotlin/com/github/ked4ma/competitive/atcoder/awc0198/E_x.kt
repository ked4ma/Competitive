package com.github.ked4ma.competitive.atcoder.awc0198

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import kotlin.math.max
import kotlin.math.min

fun main() {
    val (N, K) = nextIntList()
    val A = nextLongList()

    fun check(x: Long): Boolean {
        val maxL = sizedIntArray(N, -1)
        for (i in 0 until N) {
            val a = A[i]
            if (a == 0L) continue
            val d = x / a
            val l = max(0, i - d).toInt()
            val r = min(N - 1L, i + d).toInt()
            maxL[r] = max(maxL[r], l)
        }

        var c = 0
        var p = -1
        for (r in 0 until N) {
            if (maxL[r] > p) {
                c++
                p = r
            }
        }
        return c <= K
    }

    var ng = -1L
    var ok = LONG_INF
    while (ng + 1 < ok) {
        val m = (ng + ok) / 2
        if (check(m)) {
            ok = m
        } else {
            ng = m
        }
    }
    println(ok)
}
