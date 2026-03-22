package com.github.ked4ma.competitive.common.models.tree.segment.normal.general

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.models.tree.segment.base.*
import com.github.ked4ma.competitive.common.models.tree.segment.type.*
import com.github.ked4ma.competitive.common.number.int.bit.ceil.*

class GeneralSegmentTree<S, F>(
    n: Int,
    private val d: Array<S>,
    private val op: Op<S>,
    private val mapping: Mapping<S, F>,
    private val e: S,
) : SegmentTreeBase(n) {

    fun init(data: Iterable<S>) {
        data.forEachIndexed { i, x ->
            d[size + i] = x
        }
        for (i in size - 1 downTo 1) update(i)
    }

    fun init(data: Array<S>) {
        for (i in 0 until _n) d[size + i] = data[i]
        for (i in size - 1 downTo 1) update(i)
    }

    fun set(i: Int, x: F) {
        var i = i
        _debug_require(i in 0 until _n) { "i must be in [0, $_n)" }
        i += size
        d[i] = mapping(d[i], x)
        for (j in 1..log) update(i shr j)
    }

    fun get(i: Int): S {
        _debug_require(i in 0 until _n) { "i must be in [0, $_n)" }
        return d[i + size]
    }

    fun query(l: Int, r: Int): S {
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
        inline fun <reified S, reified F> getInstance(
            n: Int,
            noinline op: Op<S>,
            noinline mapping: Mapping<S, F>,
            e: S,
        ): GeneralSegmentTree<S, F> {
            val x = n.bitCeil()
            val dat = Array(2 * x) { e }
            return GeneralSegmentTree(
                n = x,
                d = dat,
                op = op,
                mapping = mapping,
                e = e,
            )
        }
    }
}
