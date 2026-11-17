package com.github.ked4ma.competitive.atcoder.awc0202

import com.github.ked4ma.competitive.common.input.default.*

fun main() {
    val (N, X, Y) = nextIntList()
    val ans = StringBuilder()
    repeat(N) {
        val (A, B) = nextIntList()
        ans.append(if (A >= X && B <= Y) 'G' else 'B')
    }
    println(ans)
}
