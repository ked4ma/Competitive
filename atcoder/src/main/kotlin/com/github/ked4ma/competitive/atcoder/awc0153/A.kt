package com.github.ked4ma.competitive.atcoder.awc0153

import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.abs

fun main() {
    val (N, K) = nextIntList()
    val A = nextLongList().toLongArray()
    val B = nextIntList()
    val C = nextLongList()

    var ans = 0L
    for (i in 0 until N - 1) {
        ans += abs(A[i + 1] - A[i])
    }
    for (i in 0 until K) {
        val j = B[i] - 1
        if (j - 1 >= 0) {
            ans -= abs(A[j] - A[j - 1])
        }
        if (j + 1 < N) {
            ans -= abs(A[j + 1] - A[j])
        }
        A[j] = C[i]
        if (j - 1 >= 0) {
            ans += abs(A[j] - A[j - 1])
        }
        if (j + 1 < N) {
            ans += abs(A[j + 1] - A[j])
        }
    }
    println(ans)
}
