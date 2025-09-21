package com.github.ked4ma.competitive.atcoder.abc424

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.boolean.d1.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val G = sizedArray(N + 1) { mutableSetOf<Int>() }
    repeat(N) {
        val i = it + 1
        val (A, B) = nextIntList()
        G[A].add(i)
        G[B].add(i)
    }
    val vis = sizedBooleanArray(N + 1, false)
    fun dfs(u: Int = 0) {
        if (vis[u]) return
        vis[u] = true
        for (v in G[u]) {
            if (vis[v]) continue
            dfs(v)
        }
    }
    dfs()
    println(vis.count { it } - 1)
}
