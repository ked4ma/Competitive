package com.github.ked4ma.competitive.atcoder.awc0179

import com.github.ked4ma.competitive.common.array.int.bound.*
import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*

fun main() {
    val N = nextInt()
    val A = nextIntList()

    val arr = sizedIntArray(N, INT_INF)
    for (a in A) {
        val i = arr.upperBound(a)
        arr[i] = a
    }
    _debug_println(arr)
    println(N - arr.lowerBound(INT_INF))
}
