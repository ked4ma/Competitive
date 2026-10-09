package com.github.ked4ma.competitive.atcoder.awc0174

import com.github.ked4ma.competitive.common.input.default.*

fun main() {
    val (N, K) = nextIntList().let { (N, K) -> N to K.toLong() }
    val A = nextLongList().groupingBy { it }.eachCount()
    var ans = 0L
    for ((k, c) in A) {
        if (k * 2 == K) {
            ans += c.toLong() * (c.toLong() - 1) / 2
        } else if (k < K - k  && K - k in A) {
            ans += c.toLong() * A.getValue(K - k).toLong()
        }
    }
    println(ans)
}
