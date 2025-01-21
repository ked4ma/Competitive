package com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.raq.sum

import com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.*

fun LazySegmentTree.Companion.RAQ_RSQ(
    size: Int,
    ex: Long = 0L,
    em: Long = 0L
) = LazySegmentTree(
    n = size,
    fx = { x1, x2 -> x1 + x2 },
    fa = { x, m -> x + m },
    fm = { m1, m2 -> m1 + m2 },
    fp = { m, i -> m * i },
    ex = ex,
    em = em,
)