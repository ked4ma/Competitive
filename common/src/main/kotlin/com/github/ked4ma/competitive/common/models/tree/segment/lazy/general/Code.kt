package com.github.ked4ma.competitive.common.models.tree.segment.lazy.general

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.models.tree.segment.base.*
import com.github.ked4ma.competitive.common.models.tree.segment.type.*
import com.github.ked4ma.competitive.common.number.int.bit.*
import com.github.ked4ma.competitive.common.number.int.bit.ceil.*

// ref:  https://github.com/atcoder/ac-library/blob/master/atcoder/lazysegtree.hpp
// ref2: https://atcoder.github.io/ac-library/production/document_ja/lazysegtree.html
class GeneralLazySegmentTree<S, F>(
    n: Int,
    private val op: Op<S>,
    private val mapping: Mapping<S, F>,
    private val composition: Composition<F>,
    private val propagation: Propagation<F> = { m, _ -> m },
    private val e: S,
    private val id: F,
    private val d: Array<S>,
    private val lz: Array<F>,
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

    fun set(i: Int, x: S) {
        _debug_require(i in 0 until _n) { "i($i) must be in 0 until $_n" }
        val idx = i + size
        for (k in log downTo 1) push(idx shr k, k)
        d[idx] = x
        for (k in 1..log) update(idx shr k)
    }

    fun get(i: Int): S {
        _debug_require(i in 0 until _n) { "i($i) must be in 0 until $_n" }
        val idx = i + size
        for (k in log downTo 1) push(idx shr k, k)
        return d[idx]
    }

    fun query(l: Int, r: Int): S {
        _debug_require(0 <= l && l <= r && r <= _n) { "(l, r) = ($l, $r) must be '0 <= l && l <= r && r <= $_n'" }
        if (l == r) return e

        var l = l + size
        var r = r + size

        for (i in log downTo 1) {
            if (((l shr i) shl i) != l) push(l shr i, i)
            if (((r shr i) shl i) != r) push((r - 1) shr i, i)
        }

        var sml = e
        var smr = e
        while (l < r) {
            if (l.bit(0)) sml = op(sml, d[l++])
            if (r.bit(0)) smr = op(d[--r], smr)
            l = l shr 1
            r = r shr 1
        }

        return op(sml, smr)
    }

    fun queryAll(): S = d[1]

    fun apply(i: Int, f: F) {
        _debug_require(i in 0 until _n) { "i($i) must be in 0 until $_n" }
        val idx = i + size
        for (k in log downTo 1) push(idx shr k, k)
        d[idx] = mapping(d[idx], f)
        for (k in 1..log) update(idx shr k)
    }

    fun apply(l: Int, r: Int, f: F) {
        _debug_require(0 <= l && l <= r && r <= _n) { "(l, r) = ($l, $r) must be '0 <= l && l <= r && r <= $_n'" }
        if (l == r) return

        val l = l + size
        val r = r + size

        for (i in log downTo 1) {
            if (((l shr i) shl i) != l) push(l shr i, i)
            if (((r shr i) shl i) != r) push((r - 1) shr i, i)
        }

        run {
            var l2 = l
            var r2 = r
            var h = 1
            while (l2 < r2) {
                if (l2.bit(0)) allApply(l2++, f, h)
                if (r2.bit(0)) allApply(--r2, f, h)
                l2 = l2 shr 1
                r2 = r2 shr 1
                h++
            }
        }

        for (i in 1..log) {
            if (((l shr i) shl i) != l) update(l shr i)
            if (((r shr i) shl i) != r) update((r - 1) shr i)
        }
    }

    fun maxRight(l: Int, g: (S) -> Boolean): Int {
        _debug_require(l in 0.._n) { "l($l) must in 0 .. $_n" }
        if (l == _n) return _n
        var l = l + size
        for (i in log downTo 1) push(l shr i)
        var sm = e
        do {
            while (l % 2 == 0) l = l shr 1
            if (!g(op(sm, d[l]))) {
                while (l < size) {
                    push(l)
                    l *= 2
                    if (g(op(sm, d[l]))) {
                        sm = op(sm, d[l])
                        l++
                    }
                }
                return l - size
            }
            sm = op(sm, d[l])
            l++
        } while ((l and -l) != l)
        return _n
    }

    fun minLeft(r: Int, g: (S) -> Boolean): Int {
        _debug_require(r in 0.._n) { "r($r) must in 0 .. $_n" }
        if (r == 0) return 0
        var r = r + size
        for (i in log downTo 1) push((r - 1) shr i)
        var sm = e
        do {
            r--
            while (r > 1 && r.bit(0)) r = r shr 1
            if (!g(op(sm, d[r]))) {
                while (r < size) {
                    push(r)
                    r = 2 * r + 1
                    if (g(op(sm, d[r]))) {
                        sm = op(sm, d[r])
                        r--
                    }
                }
                return r + 1 - size
            }
            sm = op(sm, d[r])
        } while ((r and -r) != r)
        return 0
    }

    private fun update(k: Int) {
        d[k] = op(d[2 * k], d[2 * k + 1])
    }

    private fun allApply(k: Int, f: F, h: Int = 1) {
        d[k] = if (f == id) d[k] else mapping(d[k], propagation(f, 1 shl (h - 1)))
        if (k < size) lz[k] = if (f == id) lz[k] else composition(lz[k], f)
    }

    private fun push(k: Int, h: Int = 1) {
        allApply(2 * k, lz[k], h)
        allApply(2 * k + 1, lz[k], h)
        lz[k] = id
    }

    companion object {
        inline fun <reified T, reified F> instanceOf(
            n: Int,
            noinline op: Op<T>,
            noinline mapping: Mapping<T, F>,
            noinline composition: Composition<F>,
            noinline propagation: Propagation<F> = { m, _ -> m },
            e: T,
            id: F,
        ): GeneralLazySegmentTree<T, F> {
            val size: Int = n.bitCeil()
            val d = sizedArray(2 * size, e)
            val lz = sizedArray(2 * size, id)
            return GeneralLazySegmentTree(
                n,
                op,
                mapping,
                composition,
                propagation,
                e,
                id,
                d,
                lz
            )
        }
    }
}
