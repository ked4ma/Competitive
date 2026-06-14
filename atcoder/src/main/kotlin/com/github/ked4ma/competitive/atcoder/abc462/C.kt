package com.github.ked4ma.competitive.atcoder.abc462

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.tree.fenwick.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val XY = times(N) {
        val (X, Y) = nextIntList()
        X to Y
    }.sortedBy { it.first }
    val yCnt = FenwickTree(N + 1)

    var ans = 0
    for ((_, y) in XY) {
        if (yCnt.sum(0, y) == 0L) ans++
        yCnt.add(y, 1)
    }
    println(ans)
}
