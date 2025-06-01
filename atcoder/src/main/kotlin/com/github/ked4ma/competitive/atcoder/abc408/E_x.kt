package com.github.ked4ma.competitive.atcoder.abc408

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.unionfind.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val edges = times(M) {
        val (u, v, w) = nextIntList()
        Triple(u - 1, v - 1, w)
    }
    var ans = 0
    for (i in range(30).reversed()) {
        val uf = UnionFind(N)
        for ((u, v, w) in edges) {
            if ((w shr i) or (ans shr i) != ans shr i) continue
            uf.unite(u, v)
        }
        if (!uf.same(0, N - 1)) ans = ans or (1 shl i)
    }
    println(ans)
}
