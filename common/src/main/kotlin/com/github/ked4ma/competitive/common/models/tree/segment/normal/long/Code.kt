package com.github.ked4ma.competitive.common.models.tree.segment.normal.long

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.models.tree.segment.base.*
import com.github.ked4ma.competitive.common.models.tree.segment.type.*
import kotlin.math.max
import kotlin.math.min

// ref: https://github.com/atcoder/ac-library/blob/master/atcoder/segtree.hpp
class SegmentTree(
    n: Int,
    private val op: Op<Long>,
    private val mapping: Mapping<Long, Long>,
    private val e: Long,
) : SegmentTreeBase(n) {
    private val d = sizedLongArray(2 * size, e)

    fun init(data: Iterable<Long>) {
        data.forEachIndexed { i, x ->
            d[size + i] = x
        }
        for (i in size - 1 downTo 1) update(i)
    }

    fun init(data: LongArray) {
        for (i in 0 until _n) d[size + i] = data[i]
        for (i in size - 1 downTo 1) update(i)
    }

    fun set(i: Int, x: Long) {
        var i = i
        _debug_require(i in 0 until _n) { "i must be in [0, $_n)" }
        i += size
        d[i] = mapping(d[i], x)
        for (j in 1..log) update(i shr j)
    }

    fun get(i: Int): Long {
        _debug_require(i in 0 until _n) { "i must be in [0, $_n)" }
        return d[i + size]
    }

    fun query(l: Int, r: Int): Long {
        _debug_require(l in 0..r && r <= _n) { "[l, r] must be in [0, $_n]" }
        var sml = e
        var smr = e
        var l = l + size
        var r = r + size

        while (l < r) {
            if (l and 1 == 1) sml = op(sml, d[l++]);
            if (r and 1 == 1) smr = op(d[--r], smr);
            l = l shr 1
            r = r shr 1
        }
        return op(sml, smr);
    }

    fun queryAll() = d[1]

    // ref: https://github.com/atcoder/ac-library/blob/master/atcoder/segtree.hpp#L69-L121
    //   fun maxRight(...)
    //   fun minLeft(...)

    private fun update(k: Int) {
        d[k] = op(d[2 * k], d[2 * k + 1])
    }

    companion object {
        fun RUQ_RMQ(size: Int) = SegmentTree(
            n = size,
            op = { a, b -> max(a, b) },
            mapping = { _, f -> f },
            e = Long.MIN_VALUE,
        )

        fun RUQ_RmQ(size: Int) = SegmentTree(
            n = size,
            op = { a, b -> min(a, b) },
            mapping = { _, f -> f },
            e = Long.MAX_VALUE,
        )

        fun RUQ_RSQ(size: Int) = SegmentTree(
            n = size,
            op = { a, b -> a + b },
            mapping = { _, f -> f },
            e = 0L,
        )

        fun RAQ_RMQ(size: Int) = SegmentTree(
            n = size,
            op = { a, b -> max(a, b) },
            mapping = { x, f -> x + f },
            e = Long.MIN_VALUE,
        )

        fun RAQ_RmQ(size: Int) = SegmentTree(
            n = size,
            op = { a, b -> min(a, b) },
            mapping = { x, f -> x + f },
            e = Long.MAX_VALUE,
        )

        fun RAQ_RSQ(size: Int) = SegmentTree(
            n = size,
            op = { a, b -> a + b },
            mapping = { x, f -> x + f },
            e = 0L,
        )
    }
}
