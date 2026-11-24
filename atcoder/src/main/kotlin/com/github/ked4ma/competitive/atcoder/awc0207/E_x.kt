package com.github.ked4ma.competitive.atcoder.awc0207

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.long.bound.*
import com.github.ked4ma.competitive.common.list.long.dim.compress.restore.*
import com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.*
import com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.ruq.max.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.max

fun main() {
    val (N, L, R) = nextIntList().let { (N, L, R) -> Triple(N, L.toLong(), R.toLong()) }
    val (A, B) = times(N) {
        val (A, B) = nextLongList()
        A to B
    }.unzip()
    val (A2, map) = A.compressAndRestore()
    _debug_println(A2)
    val A3 = A.sorted().distinct()
    val segTree = LazySegmentTree.RUQ_RMQ(N, e = 0)
    val segTree2 = LazySegmentTree.RUQ_RMQ(N, e = 0)
    for (i in 0 until N) {
        val a = A2[i]
        val a2 = map.getValue(a)
        val b = B[i]
        val x = run {
            val l = A3.lowerBound(a2 - R)
            val r = A3.upperBound(a2 - L)
//            val l = A3.lowerBound(L - a2)
//            val r = A3.upperBound(R - a2)
            segTree2.query(l, r)
        }
        val y = run {
//            val l = A3.lowerBound(a2 - R)
//            val r = A3.upperBound(a2 - L)
            val l = A3.lowerBound(L + a2)
            val r = A3.upperBound(R + a2)
            segTree.query(l, r)
        }
        segTree.set(a, maxOf(segTree.get(a), x + b))
        segTree2.set(a, maxOf(segTree2.get(a), y + b))
        _debug_println(N == 3) { "$x $y, ${max(x, x + b)} ${max(y, y + b)}" }
    }
    println(max(segTree.queryAll(), segTree2.queryAll()))
}
