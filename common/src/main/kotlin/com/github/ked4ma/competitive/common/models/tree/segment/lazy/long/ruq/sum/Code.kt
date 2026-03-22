package com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.ruq.sum

import com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.*

fun LazySegmentTree.Companion.RUQ_RSQ(
    size: Int,
    e: Long = 0,
    id: Long = Long.MIN_VALUE
) = LazySegmentTree(
    n = size,
    op = { x1, x2 -> x1 + x2 },
    mapping = { _, m -> m },
    composition = { _, m2 -> m2 },
    propagation = { m, i -> m * i },
    e = e,
    id = id,
)
