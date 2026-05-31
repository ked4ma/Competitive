package com.github.ked4ma.competitive.common.math.gcd.int

import com.github.ked4ma.competitive.common.debug.*

// gcd
fun gcd(x: Int, y: Int): Int {
    _debug_require(x != 0 || y != 0) { "(x, y) = (0, 0) is not allowed" }
    if (x == 0) return y
    if (y == 0) return x
    fun innerGcd(x: Int, y: Int): Int {
        return if (x % y == 0) y else innerGcd(y, x % y)
    }
    return if (x >= y) innerGcd(x, y) else innerGcd(y, x)
}
