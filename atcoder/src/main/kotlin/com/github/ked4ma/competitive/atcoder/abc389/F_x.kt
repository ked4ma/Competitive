package com.github.ked4ma.competitive.atcoder.abc389

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.tree.segment.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val M = 500_005
    val segTree = SegmentTree.RAQ_RSQ(M)
    segTree.init(sizedLongArray(M, 1))

    _debug_println(segTree.query(0, 1))
    _debug_println(segTree.query(0, 2))

    fun lwb(x: Int): Int {
        var l = 0
        var r = M + 1
        while (l + 1 < r) {
            val m = (l + r) / 2
            if (segTree.query(0, m) < x) {
                l = m
            } else {
                r = m
            }
        }
        return l
    }

    repeat(N) {
        val (L, R) = nextIntList()
        val li = lwb(L)
        val ri = lwb(R + 1)
        segTree.update(li, 1)
        segTree.update(ri, -1)
    }

    val Q = nextInt()
    repeat(Q) {
        val X = nextInt()
        println(segTree.query(0, X))
    }
}
