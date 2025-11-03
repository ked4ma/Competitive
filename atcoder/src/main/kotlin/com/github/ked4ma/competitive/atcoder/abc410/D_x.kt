package com.github.ked4ma.competitive.atcoder.abc410

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.boolean.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*
import com.github.ked4ma.competitive.common.repeat.range.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val G = sizedArray(N * 1024) { mutableListOf<Int>() }
    times(M) {
        val (A, B, W) = nextIntList()
        for (s in range(1024)) {
            G[(A - 1) * 1024 + s].add((B - 1) * 1024 + (s xor W))
        }
    }
    var ans = Int.MAX_VALUE
    val vis = sizedBooleanArray(N * 1024)
    fun dfs(u: Int = 0) {
        if (u / 1024 == N - 1) {
            ans = min(ans, u % 1024)
        }
        vis[u] = true
        for (v in G[u]) {
            if (vis[v]) continue
            dfs(v)
        }
    }
    dfs()
    if (ans == Int.MAX_VALUE) ans = -1
    println(ans)
}
