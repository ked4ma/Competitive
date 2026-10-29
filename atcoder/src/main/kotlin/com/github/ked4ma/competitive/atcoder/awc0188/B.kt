package com.github.ked4ma.competitive.atcoder.awc0188

import com.github.ked4ma.competitive.common.input.default.*

fun main() {
    val N = nextInt()
    val A = nextIntList()
    var ans = -1
    var n = 0
    for (i in 1 until N) {
        if (A[i] - A[i - 1] > n) {
            ans = i
            n = A[i] - A[i - 1]
        }
    }
    println(ans)
}
