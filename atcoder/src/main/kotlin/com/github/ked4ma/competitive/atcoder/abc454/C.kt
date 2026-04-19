package com.github.ked4ma.competitive.atcoder.abc454

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.boolean.d1.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val G = sizedArray(N) { mutableSetOf<Int>() }
    repeat(M) {
        val (A, B) = nextIntList().map { it - 1 }
        G[A].add(B)
    }
    val vis = sizedBooleanArray(N)
    val queue = ArrayDeque<Int>()
    vis[0] = true
    queue.add(0)
    while (queue.isNotEmpty()) {
        val u = queue.removeFirst()
        for (v in G[u]) {
            if (vis[v]) continue
            vis[v] = true
            queue.add(v)
        }
    }
    println(vis.count { it })
}
