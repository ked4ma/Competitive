package com.github.ked4ma.competitive.atcoder.abc423

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val A = nextLongList()
    val aCum = sizedLongArray(N + 1, 0)
    val jaCum = sizedLongArray(N + 1, 0)
    val j2aCum = sizedLongArray(N + 1, 0)
    run {
        for (i in 0 until N) {
            val j = i + 1
            val a = A[i]
            aCum[j] = aCum[i] + a
            jaCum[j] = jaCum[i] + a * j
            j2aCum[j] = j2aCum[i] + a * j * j
        }
    }
    _debug_println(aCum)
    _debug_println(jaCum)
    _debug_println(j2aCum)

    repeat(Q) {
        val (Li, Ri) = nextIntList()
        val L = Li - 1L
        val R = Ri + 1L
        val ans =
            -(j2aCum[Ri] - j2aCum[Li - 1]) + (L + R) * (jaCum[Ri] - jaCum[Li - 1]) - L * R * (aCum[Ri] - aCum[Li - 1])
        println(ans)
    }
}
