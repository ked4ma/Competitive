package com.github.ked4ma.competitive.atcoder.abc397

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextIntList()
    val G = sizedArray(N * K) { mutableListOf<Int>() }
    repeat(N * K - 1) {
        val (u, v) = nextIntList().map { it - 1 }
        G[u].add(v)
        G[v].add(u)
    }

    fun dfs(u: Int, p: Int = -1): Pair<Boolean, Int> {
        var ok = true
        var res = 1
        var cnt = 0
        for (v in G[u]) {
            if (v == p) continue
            val (a, b) = dfs(v, u)
            _debug_println("$v $a $b")
            ok = ok && a
            res += b
            if (b > 0) cnt++
        }
        if (u == 2) _debug_println("$ok $res")
        return if (!ok || cnt > 2 || res > K) {
            false to res % K
        } else if (cnt == 2) {
            (res == K) to res % K
        } else {
            true to res % K
        }
    }

    val ans = dfs(0)
    println(if (ans.first) "Yes" else "No")
}
