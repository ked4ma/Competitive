package com.github.ked4ma.competitive.common.math.ulong.pow

import com.github.ked4ma.competitive.common.debug.*

fun ULong.pow(n: Int): ULong {
    _debug_require(n >= 0) { "n($n) must be greater than or equal to zero(0)." }
    var res = 1UL
    var i = n
    var m = this
    while (i > 0L) {
        if (i and 1 == 1) {
            res *= m
        }
        m *= m
        i = i shr 1
    }
    return res
}