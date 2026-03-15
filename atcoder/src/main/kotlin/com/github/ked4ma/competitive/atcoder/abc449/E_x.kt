package com.github.ked4ma.competitive.atcoder.abc449

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.array.int.output.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.tree.fenwick.*
import com.github.ked4ma.competitive.common.models.tree.fenwick.bound.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val A = nextIntList()
    val cnt = sizedIntArray(M)
    for (a in A) {
        cnt[a - 1]++
    }
    val g = sizedArray(N + 1) { mutableListOf<Int>() }
    for (i in 0 until M) {
        g[cnt[i]].add(i)
    }
    val Q = nextInt()
    val q = times(Q) { nextLong() }.withIndex().sortedBy { it.value }
    val ans = sizedIntArray(Q)
    val ft = FenwickTree(M)
    var gi = 0
    var pl = 0L
    var l = N.toLong()
    for ((i, x) in q) {
        if (x <= N) {
            ans[i] = A[x.toInt() - 1]
            continue
        }
        while (gi < g.size && x > l) {
            for (a in g[gi]) ft.add(a, 1)
            pl = l
            l += ft.sum(0)
            gi++
        }
        if (x <= l) {
            val rem = x - pl
            ans[i] = ft.lowerBound(rem) + 1
        } else {
            val rem = x - l
            ans[i] = ((rem - 1) % M).toInt() + 1
        }
    }
    ans.println("\n")
}
