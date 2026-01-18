package com.github.ked4ma.competitive.atcoder.abc441

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.tree.segment.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val S = nextCharArray()
    var d = N
    val segTree = SegmentTree.RAQ_RSQ(2 * N + 1)
    segTree.update(d, 1)
    var ans = 0L
    for (c in S) {
        when (c) {
            'A' -> d++
            'B' -> d--
        }
        segTree.update(d, 1)
        ans += segTree.query(0, d)
    }
    println(ans)
}
