package com.github.ked4ma.competitive.atcoder.awc0154

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.long.pow.*
import com.github.ked4ma.competitive.common.number.sqrtl.*
import com.github.ked4ma.competitive.common.repeat.*

fun main() {
    val (N, Q) = nextIntList()
    val XY = times(N) {
        val (x, y) = nextLongList()
        x to y
    }
    val arr = sizedLongArray(N)
    for (i in 0 until N) {
        val (xi, yi) = XY[i]
        var sum = 0L
        for (j in 0 until N) {
            if (i == j) continue
            val (xj, yj) = XY[j]
            sum += sqrtl((xi - xj).pow(2) + (yi - yj).pow(2))
        }
        arr[i] = sum
    }
    repeat(Q) {
        val c = nextInt() - 1
        println(arr[c])
    }
}
