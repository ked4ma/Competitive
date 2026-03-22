package com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.raq.min

import com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.*
import kotlin.math.min

fun LazySegmentTree.Companion.RAQ_RmQ(
    size: Int,
    e: Long = Long.MAX_VALUE,
    id: Long = 0L
) = LazySegmentTree(
    n = size,
    op = { x1, x2 -> min(x1, x2) },
    mapping = { x, m -> x + m },
    composition = { m1, m2 -> m1 + m2 },
    e = e,
    id = id,
)
