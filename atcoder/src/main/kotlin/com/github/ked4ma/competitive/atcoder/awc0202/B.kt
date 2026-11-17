package com.github.ked4ma.competitive.atcoder.awc0202

import com.github.ked4ma.competitive.common.input.default.*

fun main() {
    val (N, K) = nextIntList()
    val S = next()

    var k = 0
    for (i in 0 until N) {
        val c = S[i]
        if (c == 'S') {
            k++
            if (k == K) {
                println(i + 1)
                return
            }
        }
    }
    println(-1)
}
