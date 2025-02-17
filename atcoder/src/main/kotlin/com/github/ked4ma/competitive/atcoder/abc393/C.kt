package com.github.ked4ma.competitive.atcoder.abc393

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val G = sizedArray(N) { mutableSetOf<Int>() }
    var ans = 0
    repeat(M) {
        val (u, v) = nextIntList().map { it - 1 }
        if (u == v || G[u].contains(v)) {
            ans++
            return@repeat
        }
        G[u].add(v)
        G[v].add(u)
    }
    println(ans)
}
