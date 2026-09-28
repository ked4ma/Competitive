package com.github.ked4ma.competitive.atcoder.awc0166

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.*
import com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.raq.max.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]

// passed. but contest was over...
fun main() {
    val (N, Q) = nextIntList()
    val (A, B) = times(N) {
        val (A, B) = nextLongList()
        A to B
    }.unzip().let { (A, B) -> A.toLongArray() to B.toLongArray() }

    val B2 = sizedLongArray(N + 1)
    for (i in 0 until N) {
        B2[i + 1] += B2[i] + B[i]
    }
    _debug_println(A)
    _debug_println(B)
    _debug_println(B2)
    val segTree = LazySegmentTree.RAQ_RMQ(N + 1).apply {
        for (i in 0 until N) {
            set(i, A[i] - B2[i])
        }
    }
    repeat(Q) {
        val event = nextLongList()
        when (event[0]) {
            1L -> {
                val i = event[1].toInt() - 1
                val a = event[2]
                val b = event[3]
                segTree.apply(i, a - A[i])
                segTree.apply(i + 1, N, -(b - B[i]))
                A[i] = a
                B[i] = b
            }

            2L -> {
                val s = event[1]
                var ok = -1
                var ng = N
                while (ok + 1 < ng) {
                    val m = (ok + ng) / 2
                    if (segTree.query(0, m + 1) <= s) {
                        ok = m
                    } else {
                        ng = m
                    }
                }
                println(ok + 1)
            }
        }
    }
}
