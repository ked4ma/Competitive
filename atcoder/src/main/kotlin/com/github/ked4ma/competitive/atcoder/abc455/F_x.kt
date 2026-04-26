package com.github.ked4ma.competitive.atcoder.abc455

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.debug._debug_println
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.mod.*
import com.github.ked4ma.competitive.common.models.number.mod.long.*
import com.github.ked4ma.competitive.common.models.tree.segment.lazy.general.*
import com.github.ked4ma.competitive.common.models.tree.segment.type.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    MOD = MOD998244353
    data class D(val s0: ModLong, val s1: ModLong, val s2: ModLong)

    val op: Op<D> = { a, b ->
        D(a.s0 + b.s0, a.s1 + b.s1, a.s2 + b.s2)
    }
    val mapping: Mapping<D, ModLong> = { x, f ->
        x.copy(
            s1 = x.s1 + x.s0 * f,
            s2 = x.s2 + x.s1 * f * 2 + x.s0 * f * f,
        )
    }
    val composition: Composition<ModLong> = { f, g ->
        f + g
    }
    val e = D(0.toModLong(), 0.toModLong(), 0.toModLong())
    val id = 0.toModLong()

    val segTree = GeneralLazySegmentTree.instanceOf<D, ModLong>(
        N,
        op = op,
        mapping = mapping,
        composition = composition,
        e = e,
        id = id,
    )
    segTree.init(sizedArray(N) { D(1.toModLong(), 0.toModLong(), 0.toModLong()) })

    repeat(Q) {
        var (l, r, a) = nextIntList()
        l--
        segTree.apply(l, r, a.toModLong())
        val s = segTree.query(l, r)
        _debug_println(s)
        val ans = (s.s1 * s.s1 - s.s2) / 2
        println(ans.toLong())
    }
}
