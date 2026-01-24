package com.github.ked4ma.competitive.common.number.sqrtl

import com.github.ked4ma.competitive.common.debug.*

fun sqrtl(n: Long): Long {
    _debug_require(n > 0) { "n($n) must be greater than zero(0)." }
    var ok = 0L
    var ng = Int.MAX_VALUE.toLong()
    while (ok + 1 < ng) {
        val m = (ok + ng) / 2
        if (m * m <= n) {
            ok = m
        } else {
            ng = m
        }
    }
    return ok
}
