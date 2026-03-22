package com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.raq.max

import com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.*
import kotlin.math.max

fun LazySegmentTree.Companion.RAQ_RMQ(
    size: Int,
    e: Long = Long.MIN_VALUE,
    id: Long = 0L
) = LazySegmentTree(
    n = size,
    op = { x1, x2 -> max(x1, x2) },
    mapping = { x, m -> x + m },
    composition = { m1, m2 -> m1 + m2 },
    e = e,
    id = id,
)
