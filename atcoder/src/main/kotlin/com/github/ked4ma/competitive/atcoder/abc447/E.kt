package com.github.ked4ma.competitive.atcoder.abc447

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.long.pow.*
import com.github.ked4ma.competitive.common.math.mod.*
import com.github.ked4ma.competitive.common.models.unionfind.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val MOD = MOD998244353
    val (N, M) = nextIntList()
    val edges = times(M) { i ->
        val (U, V) = nextIntList().map { it - 1 }
        Triple(i, U, V)
    }
    val uf = UnionFind(N)
    var a = 2L.powMod(M.toLong(), MOD)
    var ans = 0L
    for ((i, u, v) in edges.sortedByDescending { it.first }) {
        if (!uf.same(u, v)) {
            if (uf.size == 2) {
                ans += a
                ans %= MOD
            } else {
                uf.unite(u, v)
            }
        }
        a = a.divMod(2, MOD)
    }
    println(ans)
}
