package com.github.ked4ma.competitive.atcoder.abc446

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.boolean.d1.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val G = sizedArray(N) { mutableSetOf<Int>() }
    repeat(M) {
        val (u, v) = nextIntList().map { it - 1 }
        G[u].add(v)
    }
    val mark = sizedBooleanArray(N)
    var markCnt = 0
    val adj = sizedBooleanArray(N)
    var adjCnt = 0
    val queue = ArrayDeque<Int>()
    fun reach(k: Int) {
        if (mark[k]) return
        mark[k] = true
        markCnt++
        queue.add(k)
    }
    for (k in 0 until N) {
        if (adj[k]) adjCnt--
        if (adj[k] || k == 0) reach(k)
        while (queue.isNotEmpty()) {
            val u = queue.removeFirst()
            for (v in G[u]) {
                if (v <= k) {
                    reach(v)
                } else if (!adj[v]) {
                    adj[v] = true
                    adjCnt++
                }
            }
        }
        if (k + 1 == markCnt) {
            println(adjCnt)
        } else {
            println(-1)
        }
    }
}

// fun main() {
//     val (N, M) = nextIntList()
//     val G = sizedArray(N) { mutableSetOf<Int>() }
//     repeat(M) {
//         val (u, v) = nextIntList().map { it - 1 }
//         if (u == v) return@repeat
//         G[u].add(v)
//     }
//     val time = sizedIntArray(N, INT_INF)
//     run {
//         val queue = PriorityQueue<Pair<Int, Int>>(compareBy({ it.first }, { it.second }))
//         queue.offer(0 to 0)
//         while (queue.isNotEmpty()) {
//             _debug_println(queue)
//             val (u, t) = queue.poll()
//             if (time[u] < INT_INF) continue
//             time[u] = t
//             for (v in G[u]) {
//                 if (time[v] < INT_INF) continue
//                 queue.offer(v to max(t, u))
//             }
//         }
//     }
//     _debug_println(time)
//     val timeMap = time.withIndex().groupBy({ it.value }, { it.index }).withDefault { emptyList() }
//     _debug_println(timeMap)
//     val vis = mutableSetOf<Int>()
//     var used = 0
//     for (i in 0 until N) {
//         for (v in timeMap.getValue(i)) {
//             if (v >= i) vis.add(v) else used++
//         }
//         if (i in vis) {
//             println(if (used == i) vis.size - 1 else -1)
//             vis.remove(i)
//             used++
//         } else {
//             println(-1)
//         }
//     }
// }
