package com.github.ked4ma.competitive.common.models.tree.segment.base

import com.github.ked4ma.competitive.common.number.int.bit.ceil.*

abstract class SegmentTreeBase(n: Int) {
    protected val _n = n
    protected val size: Int = n.bitCeil()
    protected val log = size.countTrailingZeroBits()
}
