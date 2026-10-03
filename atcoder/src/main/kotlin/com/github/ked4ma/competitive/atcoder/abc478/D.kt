package com.github.ked4ma.competitive.atcoder.abc478

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.array.long.output.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.*
import com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.raq.sum.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val data = times(Q) {
        val (L, R, X) = nextIntList()
        Triple(L - 1, R, X)
    }.groupBy({ it.third }, { (l, r, _) -> l to r })

    val segTree = LazySegmentTree.RAQ_RSQ(N)
    fun add(l: Int, r: Int) {
        _debug_println("[$l, $r)")
        segTree.apply(l, r, 1)
    }
    for ((x, d) in data) {
        _debug_println("======= $x ======")
        val list = d.sortedBy { it.first }
        var (l, r) = list[0]
        var i = 1
        while (i < list.size) {
            val (l2, r2) = list[i]
            if (l2 <= r) {
                r = max(r, r2)
            } else {
                add(l, r)
                l = l2
                r = r2
            }
            i++
        }
        add(l, r)
    }
    val ans = sizedLongArray(N)
    for (i in 0 until N) {
        ans[i] = segTree.get(i)
    }
    ans.println(" ")
}
