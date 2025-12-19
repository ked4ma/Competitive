package com.github.ked4ma.competitive.atcoder.abc436

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.tree.fenwick.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val B = nextIntList()
    val ft = FenwickTree(N + 1)
    var ans = 0L
    for (b in B) {
        val left = ft.sum(0, b)
        val right = b - 1 - left
        ans += (left + 1) * (right + 1)
        ft.add(b, 1)
    }
    println(ans)
}
