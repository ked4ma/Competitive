package com.github.ked4ma.competitive.atcoder.abc463

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.long.output.*
import com.github.ked4ma.competitive.common.number.inf.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M, Y) = nextIntList().let { (N, M, Y) -> Triple(N, M, Y.toLong()) }
    val G = sizedArray(N + 1) { mutableListOf<Pair<Int, Long>>() }
    repeat(M) {
        val (u, v, T) = nextIntList().let { (u, v, T) -> Triple(u - 1, v - 1, T.toLong()) }
        G[u].add(v to T)
        G[v].add(u to T)
    }
    val X = nextLongList()
    for (i in 0 until N) {
        G[i].add(N to X[i])
        G[N].add(i to X[i] + Y)
    }

    val arr = sizedLongArray(N + 1, LONG_INF)
    val queue = PriorityQueue<Pair<Int, Long>>(compareBy { it.second })
    fun push(u: Int, c: Long) {
        if (arr[u] <= c) return
        arr[u] = c
        queue.add(u to c)
    }
    push(0, 0)
    while (queue.isNotEmpty()) {
        val (u, c) = queue.poll()
        if (arr[u] != c) continue
        for ((v, t) in G[u]) {
            push(v, c + t)
        }
    }
    arr.slice(1 until N).println(" ")
}
