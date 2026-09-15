package com.github.ked4ma.competitive.atcoder.awc0157

import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.abs
import kotlin.math.min

fun main() {
    val N = nextInt()
    var ans = 0L
    var x = 0L
    repeat(N) {
        val (a, b) = nextIntList()
        x += a - b
        ans = min(ans, x)
    }
    println(abs(ans))
}
