package com.github.ked4ma.competitive.atcoder.abc461

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.int.d2.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.tree.fenwick.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val m = Q + 4

    val last = sized2DIntArray(2, N)
    last[1].fill(1)
    val d = sizedArray(2) { FenwickTree(m) }
    repeat(2) { i ->
        d[i].add(i, N.toLong())
    }

    var ans = 0L
    for (t in 2 until Q + 2) {
        val (x, i) = nextIntList().map { it - 1 }
        val now = d[x xor 1].sum(last[x][i], t)
        if (x == 1) {
            ans -= now
        } else {
            ans += now
        }
        println(ans)

        d[x].add(last[x][i], -1)
        last[x][i] = t
        d[x].add(last[x][i], 1)
    }
}
