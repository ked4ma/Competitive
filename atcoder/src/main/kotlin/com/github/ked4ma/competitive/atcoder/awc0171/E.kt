package com.github.ked4ma.competitive.atcoder.awc0171

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.tree.segment.normal.general.*
import kotlin.math.abs

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q, K) = nextIntList()
    val A = nextIntList()

    data class D(val l: Int, val r: Int, val f: Int, val s: Int)

    val segTree = GeneralSegmentTree.getInstance<D, Int>(
        n = N,
        op = { (l1, r1, f1, s1), (l2, r2, f2, s2) ->
            if (l1 < 0 && r1 < 0) {
                D(l2, r2, f2, s2)
            } else if (l2 < 0 && r2 < 0) {
                D(l1, r1, f1, s1)
            } else {
                val sc = listOf(abs(r1 - l2), f1, s1, f2, s2).sortedDescending()
                D(l1, r2, sc[0], sc[1])
            }
        },
        mapping = { _, m ->
            D(m, m, 0, 0)
        },
        e = D(-1, -1, -1, -1)
    )
    for (i in 0 until N) {
        segTree.set(i, A[i])
    }
    _debug_println(segTree.get(0))
    _debug_println(segTree.query(0, 2))

    repeat(Q) {
        val q = nextIntList()
        when (q[0]) {
            1 -> {
                val p = q[1] - 1
                val v = q[2]
                segTree.set(p, v)
            }

            2 -> {
                val l = q[1] - 1
                val r = q[2]
                val d = segTree.query(l, r)
                println(if (d.f <= K) d.f else d.s)
            }
        }
    }
}
