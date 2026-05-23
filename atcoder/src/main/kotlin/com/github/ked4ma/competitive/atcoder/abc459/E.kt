package com.github.ked4ma.competitive.atcoder.abc459

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.mod.*
import com.github.ked4ma.competitive.common.models.number.mod.long.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    MOD = MOD998244353
    val N = nextInt()
    val P = nextIntList()
    val C = nextLongList()
    val D = nextLongList()

    val G = sizedArray(N) { mutableListOf<Int>() }
    for (i in 1 until N) {
        val p = P[i - 1] - 1
        G[p].add(i)
    }
    _debug_println(G)

    var ans = 1.toModLong()
    fun dfs(u: Int = 0): Long {
        var c = C[u]
        for (v in G[u]) {
            val rem = dfs(v)
            c += rem
        }
        val d = D[u]
        if (d > c) {
            ans = 0.toModLong()
            return 0
        }
        for (i in 0 until d) {
            ans *= (c - i)
            ans /= i + 1
        }
        return c - d
    }
    dfs()
    println(ans.toLong())
}
