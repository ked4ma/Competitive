package com.github.ked4ma.competitive.atcoder.arc224

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.array.int.output.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private fun solve() {
    val (N, M) = nextIntList()
    val G = sizedArray(N) { mutableListOf<Int>() }
    repeat(M) {
        val (u, v) = nextIntList().map { it - 1 }
        G[u].add(v)
        G[v].add(u)
    }
    val arr = sizedIntArray(N, -1)
    fun dfs(u: Int = 0, c: Int = 0) {
        if (arr[u] != -1) return
        arr[u] = c
        for (v in G[u]) {
            dfs(v, c + 1)
        }
    }
    dfs()
    arr.println(" ")
}
