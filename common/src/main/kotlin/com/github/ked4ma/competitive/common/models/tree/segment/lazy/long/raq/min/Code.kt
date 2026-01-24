package com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.raq.min

import com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.*
import kotlin.math.min

fun LazySegmentTree.Companion.RAQ_RmQ(
    size: Int,
    ex: Long = Long.MAX_VALUE,
    em: Long = 0L
) = LazySegmentTree(
    n = size,
    fx = { x1, x2 -> min(x1, x2) },
    fa = { x, m -> x + m },
    fm = { m1, m2 -> m1 + m2 },
    ex = ex,
    em = em,
)
