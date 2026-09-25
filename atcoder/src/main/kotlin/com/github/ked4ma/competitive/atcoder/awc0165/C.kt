package com.github.ked4ma.competitive.atcoder.awc0165

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val U = sizedLongArray(N)
    U[0] = nextLong()
    val G = sizedArray(N) { mutableListOf<Int>() }
    repeat(N - 1) {
        val i = it + 1
        val (p, u) = nextIntList()
        G[p - 1].add(i)
        U[i] = u.toLong()
    }
    fun dfs(u: Int = 0): Long {
        var lim = U[u]
        for (v in G[u]) {
            lim = min(lim, dfs(v))
        }
        U[u] = lim
        return lim
    }
    dfs()
    _debug_println(U)
    if (U[0] == 0L) {
        println(-1)
        return
    }
    U[0] = 1
    println(U.sum())
}
