package com.github.ked4ma.competitive.common.math.long.pow

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.math.mod.*
import com.github.ked4ma.competitive.common.number.long.bit.*

fun Long.pow(n: Int): Long = this.pow(n.toLong())
fun Long.pow(n: Long): Long {
    _debug_require(n >= 0) { "n($n) must be greater than or equal to zero(0)." }
    var res = 1L
    var i = n
    var m = this
    while (i > 0L) {
        if (i and 1L == 1L) {
            res *= m
        }
        m *= m
        i = i shr 1
    }
    return res
}

fun Long.powMod(n: Long, mod: Long): Long {
    _debug_require(n >= 0) { "n($n) must be greater than or equal to zero(0)." }
    var res = 1L
    var i = n
    var m = this
    while (i > 0L) {
        if (i.bit(0)) {
            res = res.timesMod(m, mod)
        }
        m = m.timesMod(m, mod)
        i = i shr 1
    }
    return res
}