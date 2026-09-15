package com.github.ked4ma.competitive.atcoder.awc0157

import com.github.ked4ma.competitive.common.array.boolean.d1.*
import com.github.ked4ma.competitive.common.input.default.*

fun main() {
    val N = nextInt()
    val T = nextIntList().map { it - 1 }
    val arr = sizedBooleanArray(N)
    var ans = N
    for (t in T) {
        if (!arr[t]) {
            ans--
            arr[t] = true
        }
    }
    println(ans)
}
