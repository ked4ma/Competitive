package com.github.ked4ma.competitive.atcoder.abc392

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.*
import com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.ruq.sum.*
import com.github.ked4ma.competitive.common.repeat.range.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val P = nextIntList()

    val segTree = LazySegmentTree.RUQ_RSQ(N)
    segTree.init(sizedLongArray(N, 1))

    val ans = sizedIntArray(N, 0)
    for (i in range(N).reversed()) {
        _debug_println(segTree.query(0, 1))
        _debug_println(segTree.query(0, 2))
        _debug_println(segTree.query(0, 3))
        _debug_println(segTree.query(0, 4))
        val j = segTree.maxRight(0) { x -> x < P[i] }
        ans[j] = i + 1
        segTree.update(j, 0)
        _debug_println(segTree.query(j, j + 1))
        _debug_println("$j ${ans.joinToString(" ")}")
    }
    println(ans.joinToString(" "))
}
