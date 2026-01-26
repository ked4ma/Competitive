package com.github.ked4ma.competitive.atcoder.abc423

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.int.bit.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
@OptIn(ExperimentalUnsignedTypes::class)
fun main() {
    val (N, M, Y) = nextLongList().let { (N, M, Y) -> Triple(N.toInt(), M.toInt(), Y.toULong()) }
    val A = nextLongList().map { it.toULong() }
    val N2 = 1 shl N
    val d = ULongArray(N2) { 0UL }

    val inf = 1UL shl 60

    for (s in 0 until N2) {
        var x = 1UL
        for (i in 0 until N) {
            if (s.bit(i)) {
                val t = A[i] / gcd(x, A[i])
                if (inf / x < t) x = inf else x *= t
            }
        }
        d[s] = Y / x
    }

    // fast zeta transform
    for (i in 0 until N) {
        for (s in 0 until N2) {
            if (s.bit(i)) {
                d[s xor (1 shl i)] -= d[s]
            }
        }
    }

    var ans = 0UL
    for (s in 0 until N2) {
        if (s.countOneBits() == M) ans += d[s]
    }
    println(ans)
}

private fun gcd(x: ULong, y: ULong): ULong {
    fun innerGcd(x: ULong, y: ULong): ULong {
        return if (x % y == 0UL) y else innerGcd(y, x % y)
    }
    return if (x >= y) innerGcd(x, y) else innerGcd(y, x)
}
