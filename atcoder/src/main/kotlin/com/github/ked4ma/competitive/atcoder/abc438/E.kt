package com.github.ked4ma.competitive.atcoder.abc438

import com.github.ked4ma.competitive.common.array.any.d2.*
import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.array.long.output.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.int.bit.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val A = nextIntList().map { it - 1 }
    val queries = times(Q) {
        val (Q, B) = nextIntList()
        Q to B - 1
    }
    _debug_println(A)
    val doubling = sized2DArray(31, N) { 0 to 0L }
    run {
        for (i in 0 until N) {
            val j = A[i]
            doubling[0][i] = j to i + 1L
        }
        for (i in 1 until 31) {
            for (j in 0 until N) {
                val (a, n) = doubling[i - 1][j]
                val (b, m) = doubling[i - 1][a]
                doubling[i][j] = b to n + m
            }
        }
    }
    val ans = sizedLongArray(Q)
    for (q in 0 until Q) {
        val (k, b) = queries[q]
        var a = b
        var n = 0L
        for (i in 0 until 31) {
            if (k.bit(i)) {
                val (c, m) = doubling[i][a]
                a = c
                n += m
            }
        }
        ans[q] = n
    }
    ans.println("\n")
}
