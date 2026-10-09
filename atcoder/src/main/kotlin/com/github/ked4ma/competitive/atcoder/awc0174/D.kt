package com.github.ked4ma.competitive.atcoder.awc0174

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import com.github.ked4ma.competitive.common.repeat.*
import java.util.*

fun main() {
    val (N, M) = nextIntList()
    val e = times(M) {
        val (u, v, w) = nextIntList()
        Triple(u - 1, v - 1, w.toLong())
    }
    val K = nextInt()
    val E = nextIntList().map { it - 1 }.toSet()

    val G = sizedArray(N) { mutableListOf<Pair<Int, Long>>() }
    fun f(): Long {
        val dist = sizedLongArray(N, LONG_INF)
        val q = PriorityQueue<Pair<Int, Long>>(compareBy { it.second })
        q.add(0 to 0)
        while (q.isNotEmpty()) {
            val (u, d) = q.poll()
            if (d >= dist[u]) continue
            dist[u] = d
            for ((v, w) in G[u]) {
                if (d + w >= dist[v]) continue
                q.offer(v to d + w)
            }
        }
        return if (dist.last() == LONG_INF) -1 else dist.last()
    }

    for (i in 0 until M) {
        if (i in E) continue
        val (u, v, w) = e[i]
        G[u].add(v to w)
        G[v].add(u to w)
    }
    val after = f()

    for (ei in E) {
        val (u, v, w) = e[ei]
        G[u].add(v to w)
        G[v].add(u to w)
    }
    println(f())
    println(after)
}
