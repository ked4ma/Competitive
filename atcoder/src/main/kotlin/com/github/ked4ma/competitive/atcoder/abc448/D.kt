package com.github.ked4ma.competitive.atcoder.abc448

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.boolean.d1.*
import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.boolean.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.int.dim.compress.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList().compress()
    val G = sizedArray(N) { mutableListOf<Int>() }
    repeat(N - 1) {
        val (u, v) = nextIntList().map { it - 1 }
        G[u].add(v)
        G[v].add(u)
    }
    val cnt = sizedIntArray(N)
    var judge = 0
    val ans = sizedBooleanArray(N)
    fun dfs(u: Int = 0, p: Int = -1) {
        cnt[A[u]]++
        if (cnt[A[u]] == 2) judge++

        ans[u] = judge > 0
        for (v in G[u]) {
            if (v == p) continue
            dfs(v, u)
        }

        cnt[A[u]]--
        if (cnt[A[u]] == 1) judge--
    }
    dfs()
    println(ans.joinToString("\n") { it.toYesNo() })
}
