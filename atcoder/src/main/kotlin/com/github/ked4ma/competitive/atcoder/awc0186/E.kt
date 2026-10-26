package com.github.ked4ma.competitive.atcoder.awc0186

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.boolean.d1.*
import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val A = nextLongList()
    val G = sizedArray(N) { mutableListOf<Int>() }
    val dig = sizedIntArray(N)
    repeat(M) {
        val (u, v) = nextIntList().map { it - 1 }
        G[v].add(u)
        dig[u]++
    }
    run {
        val vis = sizedBooleanArray(N)
        val fin = sizedBooleanArray(N)
        fun dfs(u: Int): Boolean {
            if (fin[u]) return true
            if (vis[u]) return false
            vis[u] = true
            for (v in G[u]) {
                if (!dfs(v)) return false
            }
            fin[u] = true
            return true
        }
        for (i in 0 until N) {
            if (!dfs(i)) {
                println(-1)
                return
            }
        }
    }

    val arr = sizedLongArray(N, LONG_INF)
    fun dfs(u: Int): Long {
        if (arr[u] != LONG_INF) return arr[u]
        var res = 0L
        for (v in G[u]) {
            res = max(res, dfs(v))
        }
        arr[u] = res + A[u]
        return arr[u]
    }

    var ans = 0L
    for (i in 0 until N) {
        if (dig[i] != 0) continue
        ans = max(ans, dfs(i))
    }
    println(ans)
}
