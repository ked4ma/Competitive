package com.github.ked4ma.competitive.atcoder.awc0159

import com.github.ked4ma.competitive.common.array.char.d2.*
import com.github.ked4ma.competitive.common.input.default.*

fun main() {
    val (N, M, K) = nextIntList()
    val arr = sized2DCharArray(N, M, '#')
    repeat(K) {
        val (r, c) = nextIntList().map { it - 1 }
        arr[r][c] = '.'
    }
    println(arr.joinToString("\n") { it.concatToString() })
}
