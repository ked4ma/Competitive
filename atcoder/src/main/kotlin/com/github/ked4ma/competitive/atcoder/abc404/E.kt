package com.github.ked4ma.competitive.atcoder.abc404

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.int.d2.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val C = listOf(0) + nextIntList()
    val A = (listOf(0) + nextIntList()).toIntArray()
    val G = sizedArray(N) { mutableListOf<Int>() }
    for (i in 1 until N) {
        for (j in i - C[i]..i - 1) {
            G[j].add(i)
        }
    }
    val route = A.withIndex().filter { (i, v) ->
        i == 0 || v > 0
    }.map { it.index }.windowed(2, 1)
    val cost = sized2DIntArray(N, N, INT_INF)
    run {
        val queue = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
        route.forEach { (from, to) ->
            _debug_println("$from -> $to")
            queue.offer(from to 0)
            while (queue.isNotEmpty()) {
                val (u, c) = queue.poll()
                if (cost[from][u] < INT_INF) continue
                cost[from][u] = c
                for (v in G[u]) {
                    if (v > to) continue
                    queue.offer(v to c + 1)
                }
            }
        }
    }

    var ans = 0
    for ((from, to) in route) {
        ans += cost[from][to]
    }
    println(ans)
}
