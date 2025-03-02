package com.github.ked4ma.competitive.atcoder.abc395

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.long.d2.*
import com.github.ked4ma.competitive.common.input.default.*
import java.util.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M, X) = nextIntList().let { (N, M, X) -> Triple(N, M, X.toLong()) }
    val G1 = sizedArray(N) { mutableListOf<Int>() }
    val G2 = sizedArray(N) { mutableListOf<Int>() }
    repeat(M) {
        val (v, u) = nextIntList().map { it - 1 }
        G1[v].add(u)
        G2[u].add(v)
    }
    val queue = PriorityQueue<Triple<Int, Int, Long>>(compareBy { it.third })
    queue.offer(Triple(0, 0, 0))
    val cost = sized2DLongArray(2, N, Long.MAX_VALUE)
    while (queue.isNotEmpty()) {
        val (v, x, c) = queue.poll()
        if (cost[x][v] <= c) continue
        cost[x][v] = c
        val A = if (x == 0) G1 else G2
        val B = if (x == 0) G2 else G1
        for (u in A[v]) {
            if (cost[x][v] + 1 < cost[x][u]) queue.offer(Triple(u, x, cost[x][v] + 1))
        }
        for (u in B[v]) {
            if (cost[x][v] + X + 1 < cost[1 - x][u]) queue.offer(Triple(u, 1 - x, cost[x][v] + X + 1))
        }
    }
    println(min(cost[0][N - 1], cost[1][N - 1]))
}
