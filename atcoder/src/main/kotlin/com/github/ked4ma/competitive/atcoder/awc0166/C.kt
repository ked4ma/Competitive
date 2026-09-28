package com.github.ked4ma.competitive.atcoder.awc0166

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.unionfind.*
import com.github.ked4ma.competitive.common.number.inf.*
import kotlin.math.max
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val P = nextLongList().toLongArray()
    val uf = UnionFind(N)
    repeat(M) {
        val (u, v) = nextIntList().map { it - 1 }
        if (uf.same(u, v)) return@repeat
        val pu = P[uf.find(u)]
        val pv = P[uf.find(v)]
        uf.unite(u, v)
        P[uf.find(u)] = pu + pv
    }
    var max = -LONG_INF
    var min = LONG_INF
    for (r in uf.uniqueRoots) {
        val s = uf.size(r)
        max = max(max, (P[r] + s - 1) / s)
        min = min(min, P[r] / s)
    }
    println(max - min)
}
