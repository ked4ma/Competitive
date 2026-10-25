package com.github.ked4ma.competitive.atcoder.abc481

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    var (N, M, S, T) = nextIntList()
    S--
    T--
    val G = sizedArray(N) { mutableListOf<Int>() }
    repeat(M) {
        val (A, B) = nextIntList().map { it - 1 }
        G[A].add(B)
    }
    G.forEach { it.sort() }
    data class D(val u: Int, val c: Int)

    val q = ArrayDeque<D>()
    q.add(D(S, 0))
    val dist = sizedIntArray(N, INT_INF)
    while (q.isNotEmpty()) {
        val (u, c) = q.removeFirst()
        if (dist[u] != INT_INF) continue
        dist[u] = c
        G[u].forEachIndexed { i, v ->
            if (dist[v] != INT_INF) return@forEachIndexed
            if (i == 0) {
                q.addFirst(D(v, c))
            } else {
                q.addLast(D(v, c + 1))
            }
        }
    }
    var ans = dist[T]
    if (ans == INT_INF) ans = -1
    println(ans)
}
