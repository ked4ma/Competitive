package com.github.ked4ma.competitive.atcoder.abc394

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import kotlin.collections.component1
import kotlin.collections.component2
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()

    val G = sizedArray(N) { mutableListOf<Int>() }
    val deg = sizedIntArray(N, 0)
    repeat(N - 1) {
        val (A, B) = nextIntList().map { it - 1 }
        G[A].add(B)
        G[B].add(A)
        deg[A]++
        deg[B]++
    }

    var ans = -1
    fun dfs(u: Int, p: Int = -1): Int {
        var res = 1
        val d = mutableListOf<Int>()
        for (v in G[u]) {
            if (v == p) continue
            d.add(dfs(v, u))
        }
        d.sortDescending()
        if (d.size >= 3) {
            res = d.take(3).sum() + 1
            if (d.size >= 4) {
                ans = max(ans, res + d[3])
            }
        }
        if (d.size >= 1) {
            if (d[0] + 1 > 2) {
                ans = max(ans, d[0] + 1)
            }
        }
        return res
    }
    dfs(0)

    println(ans)
}