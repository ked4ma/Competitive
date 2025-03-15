package com.github.ked4ma.competitive.common.math.gcd

// gcd
fun gcd(x: Int, y: Int): Int {
    fun innerGcd(x: Int, y: Int): Int {
        return if (x % y == 0) y else innerGcd(y, x % y)
    }
    return if (x >= y) innerGcd(x, y) else innerGcd(y, x)
}

fun gcd(x: Long, y: Long): Long {
    fun innerGcd(x: Long, y: Long): Long {
        return if (x % y == 0L) y else innerGcd(y, x % y)
    }
    return if (x >= y) innerGcd(x, y) else innerGcd(y, x)
}

// return followings
// - gcd of (a, b)
// - (x, y) satisfy equation ax + by = gcd
// return value = (gcd, x, y)
fun extGcd(a: Long, b: Long): Triple<Long, Long, Long> {
    fun logic(a: Long, b: Long): Triple<Long, Long, Long> {
        if (b == 0L) {
            return Triple(a, 1, 0)
        }
        val (g, x, y) = logic(b, a % b)
        return Triple(g, y, x - (a / b) * y)
    }
    return logic(a, b)
}

// crt
// calc crt(Chinese Remainder Theorem) with extGcd.
// solve [x≡b1(mod. m1), x≡b2(mod. m2),...] -> x≡r(mod. m)
// @return r(mod. m)
fun crt(b: List<Long>, m: List<Long>): Pair<Long, Long> {
    var r = 0L
    var M = 1L
    b.zip(m).forEach { (bi, mi) ->
        val (d, p, _) = extGcd(M, mi)
        if ((bi - r) % d != 0L) return 0L to -1L
        val tmp = (bi - r) / d * p % (mi / d)
        r += M * tmp
        M *= mi / d
    }
    return (r % M + M) % M to M
}
