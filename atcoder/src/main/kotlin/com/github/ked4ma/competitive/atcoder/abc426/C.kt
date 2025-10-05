package com.github.ked4ma.competitive.atcoder.abc426

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.tree.fenwick.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val ft = FenwickTree(N)
    for (i in 0 until N) {
        ft.add(i, 1)
    }
    var left = 0
    repeat(Q) {
        val (X, Y) = nextIntList().let { (X, Y) -> X to Y }
        if (X <= left) {
            println(0)
            return@repeat
        }
        val n = ft.sum(left, X)
        println(n)
        ft.add(Y - 1, n)
        left = X
    }
}
