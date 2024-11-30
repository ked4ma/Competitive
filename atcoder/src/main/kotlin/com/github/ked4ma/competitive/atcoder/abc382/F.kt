package com.github.ked4ma.competitive.atcoder.abc382

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.tree.segment.lazy.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W, N) = nextIntList()
    val data = times(N) {
        val (R, C, L) = nextIntList()
        Triple(R - 1, C - 1, L)
    }.withIndex().sortedByDescending { it.value.first }
    val segTree = LazySegmentTree.RUQ_RmQ(W)
    segTree.init(sizedLongArray(W, (H - 1).toLong()))
    val ans = sizedLongArray(N, 0)
    for ((i, d) in data) {
        val (r, c, l) = d
        val r2 = segTree.query(c, c + l)
        ans[i] = r2 + 1
        segTree.update(c, c + l, r2 - 1)
    }
    println(ans.joinToString("\n"))
}
