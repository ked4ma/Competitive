package com.github.ked4ma.competitive.atcoder.abc432

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.tree.fenwick.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val A = nextIntList().toIntArray()
    val cntFt = FenwickTree(500_001)
    val sumFt = FenwickTree(500_001)
    for (a in A) {
        cntFt.add(a, 1)
        sumFt.add(a, a.toLong())
    }
    val ans = mutableListOf<Long>()
    repeat(Q) {
        val (c, a, b) = nextIntList()
        when (c) {
            1 -> {
                cntFt.add(A[a - 1], -1)
                sumFt.add(A[a - 1], -A[a - 1].toLong())
                A[a - 1] = b
                cntFt.add(A[a - 1], 1)
                sumFt.add(A[a - 1], A[a - 1].toLong())
            }

            2 -> {
                var n = 0L
                if (a >= b) {
                    n += a.toLong() * N
                } else {
                    n += cntFt.sum(0, a) * a
                    n += sumFt.sum(a, b)
                    n += cntFt.sum(b, 500_001) * b
                }
                ans.add(n)
            }
        }
    }
    println(ans.joinToString("\n"))
}
