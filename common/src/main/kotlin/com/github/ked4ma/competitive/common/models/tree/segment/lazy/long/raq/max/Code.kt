package com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.raq.max

import com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.*
import kotlin.math.max

fun LazySegmentTree.Companion.RAQ_RMQ(
    size: Int,
    ex: Long = Long.MIN_VALUE,
    em: Long = 0L
) = LazySegmentTree(
    n = size,
    fx = { x1, x2 -> max(x1, x2) },
    fa = { x, m -> x + m },
    fm = { m1, m2 -> m1 + m2 },
    ex = ex,
    em = em,
)