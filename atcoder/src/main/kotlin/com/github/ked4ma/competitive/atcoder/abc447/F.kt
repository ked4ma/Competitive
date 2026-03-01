package com.github.ked4ma.competitive.atcoder.abc447

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private fun solve() {
    val N = nextInt()
    val G = sizedArray(N) { mutableListOf<Int>() }
    repeat(N - 1) {
        val (A, B) = nextIntList().map { it - 1 }
        G[A].add(B)
        G[B].add(A)
    }
    val arr = sizedIntArray(N, -1)
    fun dfs(u: Int = 0, p: Int = -1) {
        var links = G[u].size
        if (p != -1) links--
        var m = 0
        for (v in G[u]) {
            if (v == p) continue
            dfs(v, u)
            m = max(m, arr[v])
        }
        if (links == 2) {
            m = 1
        } else if (links > 2) {
            m++
        } else {
            m = 0
        }
        arr[u] = m
    }
    dfs()
    _debug_println(arr)

    var ans = 0
    fun dfs2(u: Int = 0, p: Int = -1) {
        val d = intArrayOf(0, 0)
        for (v in G[u]) {
            if (arr[v] > d[0]) {
                d[1] = d[0]
                d[0] = arr[v]
            } else if (arr[v] > d[1]) {
                d[1] = arr[v]
            }
        }
        val links = G[u].size
        if (links == 2) {
            ans = max(ans, 1)
        } else if (links == 3) {
            ans = max(ans, d[0] + 1)
        } else if (links >= 4) {
            ans = max(ans, d[0] + d[1] + 1)
        }
        _debug_println("N($N): ${u + 1} $ans ${arr.joinToString(separator = ",", prefix = "[", postfix = "]")}")
        for (v in G[u]) {
            if (v == p) continue
            var m = if (arr[v] == d[0]) d[1] else d[0]
            if (links - 1 == 2) {
                m = 1
            } else if (links - 1 > 2) {
                m++
            } else {
                m = 0
            }
            arr[u] = m
            dfs2(v, u)
        }
    }
    dfs2()

    println(ans)
}
