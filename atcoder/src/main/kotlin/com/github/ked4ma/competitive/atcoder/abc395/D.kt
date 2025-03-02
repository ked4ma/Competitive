package com.github.ked4ma.competitive.atcoder.abc395

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val P = sizedIntArray(N) { it }
    val B = sizedIntArray(N) { it }
    val BI = sizedIntArray(N) { it }

    val ans = mutableListOf<Int>()
    repeat(Q) {
        val q = nextIntList().map { it - 1 }
        when (q[0]) {
            0 -> {
                val (_, a, b) = q
                P[a] = BI[b]
            }

            1 -> {
                val (_, a, b) = q
                val c = BI[a]
                val d = BI[b]
                B[c] = b
                B[d] = a
                BI[a] = d
                BI[b] = c
            }

            2 -> {
                val (_, a) = q
                ans.add(B[P[a]] + 1)
            }
        }
        _debug_println("====")
        _debug_println(q.map { it + 1 }.joinToString(" "))
        _debug_println(P.map { it + 1 }.joinToString(" "))
        _debug_println(B.map { it + 1 }.joinToString(" "))
    }
    println(ans.joinToString("\n"))
}
