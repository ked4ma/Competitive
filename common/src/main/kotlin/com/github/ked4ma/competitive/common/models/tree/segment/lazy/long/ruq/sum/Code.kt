package com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.ruq.sum

import com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.*

fun LazySegmentTree.Companion.RUQ_RSQ(
    size: Int,
    ex: Long = 0,
    em: Long = 0
) = LazySegmentTree(
    n = size,
    fx = { x1, x2 -> x1 + x2 },
    fa = { _, m -> m },
    fm = { _, m2 -> m2 },
    fp = { m, i -> m * i },
    ex = ex,
    em = em,
)