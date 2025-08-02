package com.github.ked4ma.competitive.atcoder.abc417

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.boolean.d1.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private fun solve() {
    val (N, M, X, Y) = nextIntList()
    val G = sizedArray(N) { mutableListOf<Int>() }
    repeat(M) {
        val (u, v) = nextIntList().map { it - 1 }
        G[u].add(v)
        G[v].add(u)
    }
    for (g in G) g.sort()

    val vis = sizedBooleanArray(N)
    val ans = mutableListOf<Int>()
    fun dfs(u: Int): Boolean {
        ans.add(u + 1)
        if (u == Y - 1) return true
        vis[u] = true
        for (v in G[u]) {
            if (vis[v]) continue
            if (dfs(v)) return true
        }
        ans.removeLast()
        return false
    }
    dfs(X - 1)
    println(ans.joinToString(" "))
}
