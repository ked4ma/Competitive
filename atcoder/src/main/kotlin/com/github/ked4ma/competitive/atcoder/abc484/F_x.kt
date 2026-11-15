package com.github.ked4ma.competitive.atcoder.abc484

import com.github.ked4ma.competitive.common.boolean.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val A = nextLongList()
    val segTree = LazySegmentTree(
        n = N,
        op = { a, b ->
            if (a == -1L) return@LazySegmentTree b
            if (b == -1L) return@LazySegmentTree a
            if (a == -2L || b == -2L) return@LazySegmentTree -2L
            if (a != b) return@LazySegmentTree -2L
            a
        },
        mapping = { _, m -> m },
        composition = { _, m2 -> m2 },
        e = -1,
        id = -1,
    )
    segTree.init(A)
    repeat(Q) {
        val (t, b, c) = nextIntList()
        when (t) {
            1 -> {
                segTree.set(b - 1, c.toLong())
            }

            2 -> {
                val n = segTree.query(b - 1, c)
                println((n != -2L).toYesNo())
            }
        }
    }
}
