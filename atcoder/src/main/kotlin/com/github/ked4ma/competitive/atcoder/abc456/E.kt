package com.github.ked4ma.competitive.atcoder.abc456

import com.github.ked4ma.competitive.common.array.any.d2.*
import com.github.ked4ma.competitive.common.array.boolean.d2.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private fun solve() {
    _debug_println("=====")
    val (N, M) = nextIntList()
    val uv = times(M) {
        val (u, v) = nextIntList().map { it - 1 }
        u to v
    }.toSet()
    val W = nextInt()
    val S = times(N) { nextCharArray() }

    val G = sized2DArray(N, W) { mutableSetOf<Int>() }
    for (i in 0 until N) {
        for (w in 0 until W) {
            if (S[i][w] == 'o' && S[i][(w + 1) % W] == 'o') {
                G[i][w].add(i)
            }
        }
    }
    for ((u, v) in uv) {
        for (w in 0 until W) {
            if (S[u][w] == 'o' && S[v][(w + 1) % W] == 'o') {
                G[u][w].add(v)
            }
            if (S[v][w] == 'o' && S[u][(w + 1) % W] == 'o') {
                G[v][w].add(u)
            }
        }
    }

    val vis = sized2DBooleanArray(N, W)
    val fin = sized2DBooleanArray(N, W)
    fun dfs(u: Int, w: Int): Boolean {
        vis[u][w] = true
        for (v in G[u][w]) {
            val nw = (w + 1) % W
            if (fin[v][nw]) continue
            if (vis[v][nw] && !fin[v][nw]) return true
            if (dfs(v, nw)) return true
        }
        fin[u][w] = true
        return false
    }
    for (i in 0 until N) {
        if (S[i][0] == 'x') continue
        if (dfs(i, 0)) {
            println("Yes")
            return
        }
    }
    println("No")
}
