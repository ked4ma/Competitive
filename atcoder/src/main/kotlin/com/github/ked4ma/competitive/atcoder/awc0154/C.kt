package com.github.ked4ma.competitive.atcoder.awc0154

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.long.output.*

fun main() {
    val (N, K, Q) = nextIntList().let { (N, K, Q) -> Triple(N, K.toLong(), Q) }
    val C = nextLongList()
    val arr = sizedLongArray(N + 1)
    repeat(Q) {
        val (L, R) = nextIntList()
        arr[L - 1] += K
        arr[R] -= K
    }
    for (i in 0 until N) {
        arr[i + 1] += arr[i]
        arr[i] += C[i]
    }
    arr.slice(0 until N).println(" ")
}
