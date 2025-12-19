package com.github.ked4ma.competitive.atcoder.abc436

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.combimation.*
import com.github.ked4ma.competitive.common.models.unionfind.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val P = nextIntList()
    val uf = UnionFind(N)
    for (i in 0 until N) {
        val j = P[i] - 1
        uf.unite(i, j)
    }
    var ans = 0L
    for (r in uf.uniqueRoots) {
        val size = uf.size(r)
        if (size == 1) continue
        ans += combination(uf.size(r).toLong(), 2)
    }
    println(ans)
}
