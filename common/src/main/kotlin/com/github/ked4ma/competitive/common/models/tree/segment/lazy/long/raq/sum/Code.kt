package com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.raq.sum

import com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.*

fun LazySegmentTree.Companion.RAQ_RSQ(
    size: Int,
    e: Long = 0L,
    id: Long = 0L
) = LazySegmentTree(
    n = size,
    op = { x1, x2 -> x1 + x2 },
    mapping = { x, m -> x + m },
    composition = { m1, m2 -> m1 + m2 },
    propagation = { m, i -> m * i },
    e = e,
    id = id,
)
