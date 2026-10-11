package com.github.ked4ma.competitive.atcoder.abc479

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val L = listOf(LONG_INF) + nextLongList()
    val R = nextLongList() + listOf(LONG_INF)

    val lMin = sizedArray(N + 1, LONG_INF)
    for (i in (0 until N).reversed()) {
        lMin[i] = min(lMin[i + 1], L[i])
    }
    val rMin = sizedArray(N + 1, LONG_INF)
    for (i in 0 until N) {
        rMin[i + 1] = min(rMin[i], R[i])
    }
    _debug_println(lMin)
    _debug_println(rMin)
    for (i in 0 until N) {
        val l = min(L[i], R[i] + lMin[i + 1])
        val r = min(R[i], L[i] + rMin[i])
        _debug_println("$i: ${L[i]} ${R[i]} -> $l $r")
    }
    repeat(Q) {
        val (s, t) = nextIntList().map { it - 1 }
        if (s < t) {
            println(min(R[s], L[s] + rMin[s]))
        } else {
            println(min(L[s], R[s] + lMin[s + 1]))
        }
    }
}
