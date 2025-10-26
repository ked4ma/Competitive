package com.github.ked4ma.competitive.atcoder.abc429

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val G = sizedArray(N) { mutableListOf<Int>() }
    repeat(M) {
        val (U, V) = nextIntList().map { it - 1 }
        G[U].add(V)
        G[V].add(U)
    }
    val S = nextCharArray()

    val dist = sizedArray(N) { mutableListOf<Pair<Int, Int>>() }

    val queue = ArrayDeque<Triple<Int, Int, Int>>()
    fun push(u: Int, s: Int, d: Int) {
        if (dist[u].size >= 2) return
        for (p in dist[u]) {
            if (p.second == s) return
        }
        dist[u].add(d to s)
        queue.add(Triple(u, s, d))
    }
    for (i in 0 until S.size) {
        if (S[i] == 'S') push(i, i, 0)
    }
    while (queue.isNotEmpty()) {
        val (u, s, d) = queue.removeFirst()
        for (v in G[u]) {
            push(v, s, d + 1)
        }
    }
    for (i in 0 until S.size) {
        if (S[i] == 'D') {
            val ans = dist[i][0].first + dist[i][1].first
            println(ans)
        }
    }
}
