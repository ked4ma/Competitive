package com.github.ked4ma.competitive.atcoder.abc477

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val A = nextLongList()
    val B = nextLongList()
    val G = sizedArray(N + 1) { mutableListOf<Pair<Int, Long>>() }
    for (i in 0 until N) {
        G[i].add((i + 1) % N to A[i])
        G[(i + 1) % N].add(i to A[i])
        G[i].add(N to B[i])
        G[N].add(i to B[i])
    }
    val distN = sizedLongArray(N + 1, LONG_INF)
    val q = PriorityQueue<Pair<Int, Long>>(compareBy { it.second })
    q.offer(N to 0)
    while (q.isNotEmpty()) {
        val (u, d) = q.poll()
        if (distN[u] != LONG_INF) continue
        distN[u] = d
        for ((v, nd) in G[u]) {
            if (distN[v] != LONG_INF) continue
            q.offer(v to d + nd)
        }
    }
    _debug_println(distN)
    val dist = sizedLongArray(N + 1)
    for (i in 0 until N) {
        dist[i + 1] += dist[i]
        dist[i + 1] += A[i]
    }
    _debug_println(dist)
    repeat(Q) {
        val (S, T) = nextIntList().map { it - 1 }

        val ans = if (T == N) {
            distN[S] + distN[T]
        } else {
            minOf(
                dist[T] - dist[S],
                dist[N] - (dist[T] - dist[S]),
                distN[S] + distN[T],
            )
        }
        println(ans)
    }
}
