package com.github.ked4ma.competitive.atcoder.abc474_na

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.tree.segment.normal.long.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private fun solve() {
    val N = nextInt()
    var AB = times(N) {
        val (A, B) = nextLongList()
        A to B
    }.sortedByDescending { (a, b) -> a - b }
    val segTree = SegmentTree.RUQ_RmQ(N)
    for (i in 0 until N) {
        segTree.set(i, AB[i].first)
    }
    var a = AB.sumOf { it.first }
    var b = 0L
    var ans = a + b
    for (i in 0 until N - 1) {
        val d = N - (i + 1)
        a -= AB[i].first
        b += AB[i].second
        val c = if (d < i + 1) {
            ((i + 1) - d) * segTree.query(i + 1, N)
        } else 0
        ans = min(ans, a + b + c)
        _debug_println(ans)
    }
    println(ans)
}
