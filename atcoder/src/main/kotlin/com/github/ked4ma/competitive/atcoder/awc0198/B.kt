package com.github.ked4ma.competitive.atcoder.awc0198

import com.github.ked4ma.competitive.common.input.default.*

fun main() {
    val N = nextInt()
    val S = nextCharArray()

    var ans = -1
    for (i in 0 until N) {
        if (S[i] == 'D') ans = i + 1
    }
    println(ans)
}
