package com.github.ked4ma.competitive.atcoder.abc399

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.unionfind.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val uf = UnionFind(N)
    var ans = 0
    repeat(M) {
        val (u, v) = nextIntList().map { it - 1 }
        if (uf.same(u, v)) {
            ans++
        } else {
            uf.unite(u, v)
        }
    }
    println(ans)
}
