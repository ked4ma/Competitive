package com.github.ked4ma.competitive.atcoder.abc450

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.mod.*
import com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val MOD = MOD998244353
    val (N, M) = nextIntList()
    val rs = sizedArray(N) { mutableListOf<Int>() }
    repeat(M) {
        val (l, r) = nextIntList()
        rs[l - 1].add(r - 1)
    }
    val segTree = LazySegmentTree(
        n = N,
        op = { x1, x2 -> (x1 + x2) % MOD },
        mapping = { f, x -> (x * f) % MOD },
        composition = { f, g -> (f * g) % MOD },
        e = 0,
        id = 1,
    )
    segTree.set(0, 1)
    for (l in 0 until N) {
        for (r in rs[l]) {
            val s = segTree.query(l, r + 1)
            segTree.set(r, segTree.get(r) + s)
            segTree.apply(r + 1, N, 2)
        }
    }
    println(segTree.get(N - 1))
}
