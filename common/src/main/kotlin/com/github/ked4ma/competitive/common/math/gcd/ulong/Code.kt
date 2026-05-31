package com.github.ked4ma.competitive.common.math.gcd.ulong

import com.github.ked4ma.competitive.common.debug.*

// gcd
fun gcd(x: ULong, y: ULong): ULong {
    _debug_require(x != 0UL || y != 0UL) { "(x, y) = (0, 0) is not allowed" }
    if (x == 0UL) return y
    if (y == 0UL) return x
    fun innerGcd(x: ULong, y: ULong): ULong {
        return if (x % y == 0UL) y else innerGcd(y, x % y)
    }
    return if (x >= y) innerGcd(x, y) else innerGcd(y, x)
}
