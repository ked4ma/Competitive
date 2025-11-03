package com.github.ked4ma.competitive.atcoder.abc388

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.tree.segment.lazy.legacy.*
import com.github.ked4ma.competitive.common.repeat.range.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextLongList()

    val segTree = LazySegmentTree.RAQ_RSQ(N)
    segTree.init(A)

    for (i in range(N - 1)) {
        // 5,0,9,3
        // x = 5
        // x2 = min(0 + 5, 3) = 3
        // 2,1,10,4
        // x = 1
        // x2 = min(1 + 1, 3) = 2
        // 2,0,11,3
        val x = segTree.query(i, i + 1).toInt()
        val x2 = min(i + x, N - 1)
        segTree.update(i, i + 1, -(x2 - i).toLong())
        segTree.update(i + 1, x2 + 1, 1)
    }
    val ans = buildList {
        for (i in range(N)) {
            add(segTree.query(i, i + 1))
        }
    }
    println(ans.joinToString(" "))
}
