package com.github.ked4ma.competitive.atcoder.awc0157

import com.github.ked4ma.competitive.common.input.default.*

fun main() {
    val (N, M) = nextIntList()
    val A = nextLongList().sortedDescending()
    val L = nextLongList().sortedDescending()
    for (i in 0 until N - 1) {
        if (A[i] + A[N - 1] > L[i]) {
            println("No")
            return
        }
    }
    println("Yes")
}
