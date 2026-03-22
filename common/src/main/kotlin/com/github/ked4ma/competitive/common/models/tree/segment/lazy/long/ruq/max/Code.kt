package com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.ruq.max

import com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.*
import kotlin.math.max

fun LazySegmentTree.Companion.RUQ_RMQ(
    size: Int,
    e: Long = Long.MIN_VALUE,
    id: Long = Long.MIN_VALUE
) = LazySegmentTree(
    n = size,
    op = { x1, x2 -> max(x1, x2) },
    mapping = { _, m -> m },
    composition = { _, m2 -> m2 },
    e = e,
    id = id,
)
