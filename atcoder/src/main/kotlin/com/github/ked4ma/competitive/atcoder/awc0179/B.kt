package com.github.ked4ma.competitive.atcoder.awc0179

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*

fun main() {
    val N = nextInt()
    val A = nextIntList()
    var ans = 0
    var m = INT_INF
    for (i in 0 until N) {
        val a = A[i]
        if (a < m) {
            ans = i + 1
            m = a
        }
    }
    println(ans)
}
