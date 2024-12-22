package com.github.ked4ma.competitive.atcoder.abc385

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val G = sizedArray(N) { mutableListOf<Int>() }
    val deg = sizedIntArray(N, 0)
    repeat(N - 1) {
        val (u, v) = nextIntList().map { it - 1 }
        G[u].add(v)
        G[v].add(u)
        deg[u]++
        deg[v]++
    }
    var ans = N
    for (u in range(N)) {
        G[u].sortByDescending { deg[it] }
        var x = 0
        for (v in G[u]) {
            x++
            val y = deg[v] - 1
            ans = min(ans, N - (1 + x + x * y))
        }
    }
    println(ans)
}
