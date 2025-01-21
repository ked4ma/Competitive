package com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.ruq.min

import com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.*
import kotlin.math.min

fun LazySegmentTree.Companion.RUQ_RmQ(
    size: Int,
    ex: Long = Long.MAX_VALUE,
    em: Long = Long.MAX_VALUE
) = LazySegmentTree(
    n = size,
    fx = { x1, x2 -> min(x1, x2) },
    fa = { _, m -> m },
    fm = { _, m2 -> m2 },
    ex = ex,
    em = em,
)