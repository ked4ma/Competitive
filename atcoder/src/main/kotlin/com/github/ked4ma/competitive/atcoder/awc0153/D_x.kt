package com.github.ked4ma.competitive.atcoder.awc0153

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import java.util.*

fun main() {
    val (N, M, S) = nextIntList().let { (N, M, S) -> Triple(N, M, S - 1) }
    data class D(val u: Int, val w: Long)

    val G = sizedArray(N) { mutableListOf<D>() }
    repeat(M) {
        val (U, V, W) = nextIntList()
        G[U - 1].add(D(V - 1, W.toLong()))
        G[V - 1].add(D(U - 1, W.toLong()))
    }

    // Dijkstra's algorithm
    val q = PriorityQueue<D>(compareBy { it.w })
    q.offer(D(S, 0))
    val dist = sizedLongArray(N, LONG_INF)
    dist[S] = 0
    while (q.isNotEmpty()) {
        val (u, d) = q.poll()
        if (d > dist[u]) continue
        for ((v, w) in G[u]) {
            if (d + w < dist[v]) {
                dist[v] = d + w
                q.offer(D(v, d + w))
            }
        }
    }
    println(dist.filter { it != LONG_INF }.sum())
}
