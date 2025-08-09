package com.github.ked4ma.competitive.atcoder.abc418

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.long.bound.*
import com.github.ked4ma.competitive.common.list.long.cumlative.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val A = nextLongList().sorted()
    _debug_println(A)
    val aCum = A.cumulativeSum()
    repeat(Q) {
        val B = nextLong()
        if (B > A.last()) {
            println(-1)
            return@repeat
        }
        val bi = A.upperBound(B - 1)
        _debug_println("$bi ${aCum[bi]} ${(N - bi) * (B - 1)} ${aCum[bi] + (N - bi) * (B - 1) + 1}")
        println(aCum[bi] + (N - bi) * (B - 1) + 1)
    }
}
