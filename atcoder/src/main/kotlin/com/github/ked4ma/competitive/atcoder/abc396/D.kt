package com.github.ked4ma.competitive.atcoder.abc396

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.int.bit.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val G = sizedArray(N) { mutableListOf<Pair<Int, Long>>() }
    repeat(M) {
        val (u, v, w) = nextLongList().let { (u, v, w) -> Triple(u.toInt() - 1, v.toInt() - 1, w) }
        G[u].add(v to w)
        G[v].add(u to w)
    }

    var ans = Long.MAX_VALUE
    fun dfs(u: Int = 0, route: Int = 1, cur: Long = 0) {
        if (u == N - 1) {
            ans = min(ans, cur)
            return
        }
        for ((v, w) in G[u]) {
            if (route.bit(v)) continue
            dfs(v, route or (1 shl v), cur xor w)
        }
    }
    dfs()
    println(ans)
}
