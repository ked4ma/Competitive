package com.github.ked4ma.competitive.atcoder.awc0159

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*

fun main() {
    val (N, K) = nextIntList()
    val A = nextIntList().groupingBy { it }.eachCount().toSortedMap()
    var ans = 0L
    for ((k, c) in A) {
        _debug_println(k)
        if (K + k in A) {
            ans += c.toLong() * A.getValue(K + k).toLong()
        }
    }
    println(ans)
}
