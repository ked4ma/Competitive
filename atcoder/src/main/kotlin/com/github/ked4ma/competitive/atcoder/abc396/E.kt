package com.github.ked4ma.competitive.atcoder.abc396

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.int.bit.*
import com.github.ked4ma.competitive.common.repeat.range.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val G = sizedArray(N) { mutableListOf<Pair<Int, Int>>() }
    repeat(M) {
        val (X, Y, Z) = nextIntList()
        G[X - 1].add(Y - 1 to Z)
        G[Y - 1].add(X - 1 to Z)
    }
    var ok = true
    val ans = sizedIntArray(N, 0)
    repeat(30) { k ->
        val col = sizedIntArray(N, -1)
        for (sv in range(N)) {
            if (col[sv] != -1) continue
            val vs = sizedArray(2) { mutableListOf<Int>() }
            fun dfs(v: Int, c: Int) {
                if (col[v] != -1) {
                    if (col[v] != c) ok = false
                    return
                }
                col[v] = c
                vs[c].add(v)
                for ((u, z) in G[v]) {
                    dfs(u, c xor z.bitAt(k))
                }
            }
            dfs(sv, 0)
            if (vs[0].size < vs[1].size) vs[0] = vs[1].also { vs[1] = vs[0] }
            for (v in vs[1]) ans[v] = ans[v] or (1 shl k)
        }
    }
    if (!ok) {
        println(-1)
        return
    }
    println(ans.joinToString(" "))
}
