package com.github.ked4ma.competitive.atcoder.awc0207

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

fun main() {
    val (N, M) = nextIntList()
    val A = times(N) { nextIntList() }

    val map = mutableMapOf<Int, Int>().withDefault { 0 }
    for (i in 0 until N) {
        for (j in 0 until M) {
            val a = A[i][j]
            map[a] = map.getValue(a) + 1
        }
    }
    println(N * M - map.values.max())
}
