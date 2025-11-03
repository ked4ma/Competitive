package com.github.ked4ma.competitive.atcoder.abc401

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.boolean.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.unionfind.*
import com.github.ked4ma.competitive.common.repeat.*
import com.github.ked4ma.competitive.common.repeat.range.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val G = sizedArray(N) { mutableListOf<Int>() }
    val uv = times(M) {
        val (u, v) = nextIntList().map { it - 1 }
        G[u].add(v)
        u to v
    }.sortedBy { it.second }
    _debug_println(uv)

    val ans = mutableSetOf<Int>()
    ans.addAll(G[0])
    val uf = UnionFind(N)
    var j = 0
    val added = sizedBooleanArray(N)
    for (i in range(N)) {
        while (j < M && uv[j].second == i) {
            val (u, v) = uv[j]
            uf.unite(u, v)
            if (!added[u]) {
                ans.addAll(G[u])
                added[u] = true
            }
            if (!added[v]) {
                ans.addAll(G[v])
                added[v] = true
            }
            j++
        }
        ans.remove(i)
        if (uf.size(0) == i + 1) {
            println(ans.size)
        } else {
            println(-1)
        }
    }
}
