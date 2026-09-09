package com.github.ked4ma.competitive.atcoder.awc0153

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.input.default.*

fun main() {
    val (N, M, K) = nextIntList()
    val A = nextLongList()
    val arr = sizedLongArray(N + 1)
    repeat(M) {
        val (l, r) = nextIntList()
        arr[l - 1]++
        arr[r]--
    }
    var ans = 0
    for (i in 0 until N) {
        if (A[i] + arr[i] >= K) ans++
        arr[i + 1] += arr[i]
    }
    println(ans)
}
