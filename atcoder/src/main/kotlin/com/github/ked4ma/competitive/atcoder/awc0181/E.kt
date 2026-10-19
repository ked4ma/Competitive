package com.github.ked4ma.competitive.atcoder.awc0181

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.array.int.output.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.tree.segment.normal.general.*
import com.github.ked4ma.competitive.common.number.inf.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M, T) = nextIntList()
    val SLR = times(M) {
        val (S, L, R) = nextIntList()
        Triple(S, L - 1, R)
    }

    data class D(val x: Int = INT_INF, val i: Int = -1)

    val segTree = GeneralSegmentTree.getInstance<D, Int>(
        n = N,
        op = { a, b -> if (a.x <= b.x) a else b },
        mapping = { (x, i), a -> D(x + a, i) },
        e = D(),
    ).apply { init((0 until N).map { D(0, it) }) }
    val ans = sizedIntArray(N)
    for ((s, l, r) in SLR) {
        val d = segTree.query(l, r)
        if (T - s < 100) ans[d.i] += 100 - (T - s)
        segTree.set(d.i, 1)
    }
    ans.println(" ")
}
