package com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.ruq.max

import com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.*
import kotlin.math.max

fun LazySegmentTree.Companion.RUQ_RMQ(
    size: Int,
    ex: Long = Long.MIN_VALUE,
    em: Long = Long.MIN_VALUE
) = LazySegmentTree(
    n = size,
    fx = { x1, x2 -> max(x1, x2) },
    fa = { _, m -> m },
    fm = { _, m2 -> m2 },
    ex = ex,
    em = em,
)