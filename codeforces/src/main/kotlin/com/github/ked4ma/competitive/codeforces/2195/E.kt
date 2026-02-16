package com.github.ked4ma.competitive.codeforces.`2195`

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.array.long.output.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.mod.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val t = nextInt()
    repeat(t) {
        solve()
    }
}

private fun solve() {
    val MOD = MOD10e9_7
    val n = nextInt()
    val nodes = sizedArray(n + 1) { Node() }
    repeat(n) { i ->
        val (l, r) = nextIntList()
        if (l == 0 && r == 0) return@repeat
        nodes[i + 1].l = l
        nodes[i + 1].r = r
        nodes[l].p = i + 1
        nodes[r].p = i + 1
    }
    val cost = sizedLongArray(n + 1)
    fun dfs(u: Int = 1) {
        val node = nodes[u]
        if (node.l == null && node.r == null) return
        var c = 0L
        node.l?.let {
            dfs(it)
            c += cost[it] + 2
            c %= MOD
        }
        node.r?.let {
            dfs(it)
            c += cost[it] + 2
            c %= MOD
        }
        cost[u] = c
    }
    dfs()
    _debug_println(cost)
    val ans = sizedLongArray(n)
    fun dfs2(u: Int = 1, p: Long = 0) {
        val node = nodes[u]
        _debug_println("ans=[${ans.joinToString(" ")}]")
        ans[u - 1] = (p + cost[u] + 1) % MOD
        if (node.l == null && node.r == null) return
        dfs2(node.l!!, ans[u - 1])
        dfs2(node.r!!, ans[u - 1])
    }
    dfs2()
    ans.println(" ")
}

private data class Node(var p: Int = 0, var l: Int? = null, var r: Int? = null)
