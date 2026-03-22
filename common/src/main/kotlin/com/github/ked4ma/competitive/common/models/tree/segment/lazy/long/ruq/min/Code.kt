package com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.ruq.min

import com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.*
import kotlin.math.min

fun LazySegmentTree.Companion.RUQ_RmQ(
    size: Int,
    e: Long = Long.MAX_VALUE,
    id: Long = Long.MAX_VALUE
) = LazySegmentTree(
    n = size,
    op = { x1, x2 -> min(x1, x2) },
    mapping = { _, m -> m },
    composition = { _, m2 -> m2 },
    e = e,
    id = id,
)
