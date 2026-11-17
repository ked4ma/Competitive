package com.github.ked4ma.competitive.atcoder.awc0202

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*

fun main() {
    val N = nextInt()
    val next = sizedIntArray(N)
    var s = -1
    repeat(N) { i ->
        val (p, n) = nextIntList().map { it - 1 }
        next[i] = n
        if (p == -1) s = i
    }
    repeat(N) {
        println(s + 1)
        s = next[s]
    }
}
