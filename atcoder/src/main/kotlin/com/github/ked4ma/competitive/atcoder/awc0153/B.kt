package com.github.ked4ma.competitive.atcoder.awc0153

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import kotlin.math.abs
import kotlin.math.min

fun main() {
    val (N, M) = nextIntList()
    val X = nextIntList()
    val P = listOf(-INT_INF) + nextIntList() + listOf(INT_INF)
    var j = 0
    for (x in X) {
        while (j < M && x >= P[j]) j++
        _debug_println("$x: ${P[j]},${P[j - 1]}")
        println(min(abs(P[j] - x), abs(x - P[j - 1])))
    }
}
