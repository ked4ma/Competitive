package com.github.ked4ma.competitive.common.models.tree.segment.lazy.long

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.models.tree.segment.type.*
import com.github.ked4ma.competitive.common.number.int.bit.*
import com.github.ked4ma.competitive.common.number.int.bit.ceil.*

// ref:  https://github.com/atcoder/ac-library/blob/master/atcoder/lazysegtree.hpp
// ref2: https://atcoder.github.io/ac-library/production/document_ja/lazysegtree.html
// info:
//   update:
//     RUQ -> fm: {a, b -> b}
//     RAQ -> fm: {a, b -> a + b}
//   query:
//     RSQ -> fp: {m, i -> m * i} // calc actually updated value to the section
//            fa: {x, m -> x + m} // update value
//            fa(x, fp(m, i))
class LazySegmentTree(
    n: Int,
    private val fx: FX,
    private val fa: FA,
    private val fm: FM,
    private val fp: FP = { m, _ -> m },
    private val ex: X,
    private val em: M,
) {

    private val _n: Int = n
    private val size: Int = n.bitCeil()
    private val log: Int = size.countTrailingZeroBits()
    private val dat: LongArray = sizedLongArray(2 * size, ex)
    private val lazy: LongArray = sizedLongArray(size, em)

    fun init(data: Iterable<Long>) {
        data.forEachIndexed { i, x ->
            dat[size + i] = x
        }
        for (i in size - 1 downTo 1) update(i)
    }

    fun init(data: LongArray) {
        for (i in 0 until _n) dat[size + i] = data[i]
        for (i in size - 1 downTo 1) update(i)
    }

    fun set(i: Int, x: X) {
        _debug_require(i in 0 until _n) { "i($i) must be in 0 until $_n" }
        val idx = i + size
        for (k in log downTo 1) push(idx shr k, k)
        dat[idx] = x
        for (k in 1..log) update(idx shr k)
    }

    fun get(i: Int): X {
        _debug_require(i in 0 until _n) { "i($i) must be in 0 until $_n" }
        val idx = i + size
        for (k in log downTo 1) push(idx shr k, k)
        return dat[idx]
    }

    fun query(l: Int, r: Int): X {
        _debug_require(0 <= l && l <= r && r <= _n) { "(l, r) = ($l, $r) must be '0 <= l && l <= r && r <= $_n'" }
        if (l == r) return ex

        var ll = l + size
        var rr = r + size

        for (i in log downTo 1) {
            if (((ll shr i) shl i) != ll) push(ll shr i, i)
            if (((rr shr i) shl i) != rr) push((rr - 1) shr i, i)
        }

        var sml = ex
        var smr = ex
        while (ll < rr) {
            if (ll.bit(0)) sml = fx(sml, dat[ll++])
            if (rr.bit(0)) smr = fx(dat[--rr], smr)
            ll = ll shr 1
            rr = rr shr 1
        }

        return fx(sml, smr)
    }

    fun queryAll(): X = dat[1]

    fun update(i: Int, m: M) {
        _debug_require(i in 0 until _n) { "i($i) must be in 0 until $_n" }
        val idx = i + size
        for (k in log downTo 1) push(idx shr k, k)
        dat[idx] = fa(dat[idx], m)
        for (k in 1..log) update(idx shr k)
    }

    fun update(l: Int, r: Int, m: M) {
        _debug_require(0 <= l && l <= r && r <= _n) { "(l, r) = ($l, $r) must be '0 <= l && l <= r && r <= $_n'" }
        if (l == r) return

        val ll = l + size
        val rr = r + size

        for (i in log downTo 1) {
            if (((ll shr i) shl i) != ll) push(ll shr i, i)
            if (((rr shr i) shl i) != rr) push((rr - 1) shr i, i)
        }

        run {
            var l2 = ll
            var r2 = rr
            var h = 1
            while (l2 < r2) {
                if (l2.bit(0)) allApply(l2++, m, h)
                if (r2.bit(0)) allApply(--r2, m, h)
                l2 = l2 shr 1
                r2 = r2 shr 1
                h++
            }
        }

        for (i in 1..log) {
            if (((ll shr i) shl i) != ll) update(ll shr i)
            if (((rr shr i) shl i) != rr) update((rr - 1) shr i)
        }
    }

    fun maxRight(l: Int, g: (X) -> Boolean): Int {
        _debug_require(l in 0.._n) { "l($l) must in 0 .. $_n" }
        if (l == _n) return _n
        var ll = l + size
        for (i in log downTo 1) push(ll shr i)
        var sm = ex
        do {
            while (ll % 2 == 0) ll = ll shr 1
            if (!g(fx(sm, dat[ll]))) {
                while (ll < size) {
                    push(ll)
                    ll *= 2
                    if (g(fx(sm, dat[ll]))) {
                        sm = fx(sm, dat[ll])
                        ll++
                    }
                }
                return ll - size
            }
            sm = fx(sm, dat[ll])
            ll++
        } while ((ll and -ll) != ll)
        return _n
    }

    fun minLeft(r: Int, g: (X) -> Boolean): Int {
        _debug_require(r in 0.._n) { "r($r) must in 0 .. $_n" }
        if (r == 0) return 0
        var rr = r + size
        for (i in log downTo 1) push((rr - 1) shr i)
        var sm = ex
        do {
            rr--
            while (rr > 1 && rr.bit(0)) rr = rr shr 1
            if (!g(fx(sm, dat[rr]))) {
                while (rr < size) {
                    push(rr)
                    rr = 2 * rr + 1
                    if (g(fx(sm, dat[rr]))) {
                        sm = fx(sm, dat[rr])
                        rr--
                    }
                }
                return rr + 1 - size
            }
            sm = fx(sm, dat[rr])
        } while ((rr and -rr) != rr)
        return 0
    }

    private fun update(k: Int) {
        dat[k] = fx(dat[2 * k], dat[2 * k + 1])
    }

    private fun allApply(k: Int, m: M, h: Int = 0) {
        dat[k] = if (m == em) dat[k] else fa(dat[k], fp(m, 1 shl (h - 1)))
        if (k < size) lazy[k] = if (m == em) lazy[k] else fm(lazy[k], m)
    }

    private fun push(k: Int, h: Int = 0) {
        allApply(2 * k, lazy[k], h)
        allApply(2 * k + 1, lazy[k], h)
        lazy[k] = em
    }

    companion object
}
