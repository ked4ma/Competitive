package com.github.ked4ma.competitive.atcoder.abc485

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.boolean.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    data class D(val v: Int, val c: Int)

    val G = sizedArray(N) { mutableListOf<D>() }
    val GC = sizedArray(N) { mutableSetOf<Int>() }
    repeat(M) {
        val (u, v, c) = nextIntList().map { it - 1 }
        G[u].add(D(v, c))
        GC[u].add(c)
    }
    data class D2(val v: Int, val c: Int, val d: Int)

    val vis = mutableSetOf<D>()
    val vis2 = sizedBooleanArray(N)
    val q = PriorityQueue<D2>(compareBy { it.d })
    q.offer(D2(0, -1, 0))
    while (q.isNotEmpty()) {
        val (u, c, d) = q.poll()
        if (u == N - 1) {
            println(d)
            return
        }
        for (d2 in G[u]) {
            val (v, nc) = d2
            if (c == nc) continue
            if (d2 in vis || vis2[v]) continue
            vis.add(d2)
            if (nc !in GC[v]) vis2[v] = true
            q.offer(D2(v, nc, d + 1))
        }
    }
    println(-1)
}
