package com.github.ked4ma.competitive.atcoder.awc0173

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.input.default.*

fun main() {
    val (N, M) = nextIntList()
    val H = nextLongList()
    val arr = sizedLongArray(M + 1)
    repeat(N) {
        val (L, R, A) = nextIntList()
        arr[L - 1] += A
        arr[R] -= A
    }
    var ans = 0
    for (i in 0 until M) {
        if (arr[i] >= H[i]) ans++
        arr[i + 1] += arr[i]
    }
    println(ans)
}
