package com.github.ked4ma.competitive.atcoder.abc470

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    var P = nextIntList().map { it - 1 }.toIntArray()
    var S = sizedIntArray(N)
    for (i in 0 until N) {
        S[P[i]] = i
    }
    _debug_println(P)
    _debug_println(S)
    repeat(Q) {
        val d = nextIntList()
        when (d[0]) {
            1 -> {
                val x = d[1] - 1
                val y = d[2] - 1
                val sx = P[x]
                val sy = P[y]
                P[x] = P[y].also { P[y] = P[x] }
                S[sx] = S[sy].also { S[sy] = S[sx] }
            }

            2 -> {
                P = S.also { S = P }
            }
        }
    }
    println(P.joinToString(" ") { "${it + 1}" })
}
