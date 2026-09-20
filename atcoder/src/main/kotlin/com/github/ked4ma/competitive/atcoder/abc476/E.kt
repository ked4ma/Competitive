package com.github.ked4ma.competitive.atcoder.abc476

import com.github.ked4ma.competitive.common.array.long.output.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.*
import com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.ruq.max.*
import com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.ruq.min.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val P = nextLongList().toLongArray()

    val minTree = LazySegmentTree.RUQ_RmQ(N)
    minTree.init(P)
    val maxTree = LazySegmentTree.RUQ_RMQ(N)
    maxTree.init(P)
    val map = P.withIndex().associate { it.value to it.index }.toMutableMap()

    repeat(M) {
        val (l, r) = nextIntList().let { (l, r) -> l - 1 to r }
        val min = minTree.query(l, r)
        val max = maxTree.query(l, r)
        val iMin = map.getValue(min)
        val iMax = map.getValue(max)
        minTree.apply(iMin, max)
        minTree.apply(iMax, min)
        maxTree.apply(iMin, max)
        maxTree.apply(iMax, min)
        P[iMin] = max
        P[iMax] = min
        map[min] = iMax
        map[max] = iMin
        _debug_println("$min $max -> ${P.joinToString(" ")}")
    }
    P.println(" ")
}
