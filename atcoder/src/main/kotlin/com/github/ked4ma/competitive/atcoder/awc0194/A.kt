package com.github.ked4ma.competitive.atcoder.awc0194

import com.github.ked4ma.competitive.common.input.default.*

fun main() {
    val (N, A) = nextIntList()
    var n = A.toLong()
    repeat(N) {
        println(n)
        n *= 2
    }
}
