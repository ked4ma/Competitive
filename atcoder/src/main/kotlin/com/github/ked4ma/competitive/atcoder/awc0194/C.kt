package com.github.ked4ma.competitive.atcoder.awc0194

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*

fun main() {
    val (N, Q) = nextIntList()
    val H = nextIntList()
    val arrL = sizedIntArray(N + 1)
    val arrR = sizedIntArray(N + 1)
    for (i in 1 until N - 1) {
        if (H[i - 1] > H[i] && H[i] < H[i + 1]) {
            arrL[i] = 1
            arrR[i + 1] = 1
        }
    }
    for (i in 0 until N) {
        arrL[i + 1] += arrL[i]
        arrR[i + 1] += arrR[i]
    }
    _debug_println(arrL)
    _debug_println(arrR)
    repeat(Q) {
        val (L, R) = nextIntList()
        println(arrR[R - 1] - arrL[L - 1])
    }
}
