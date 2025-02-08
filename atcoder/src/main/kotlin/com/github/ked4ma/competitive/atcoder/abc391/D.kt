package com.github.ked4ma.competitive.atcoder.abc391

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.collections.component1
import kotlin.collections.component2

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, W) = nextIntList()
    val XY = times(N) {
        val (X, Y) = nextIntList()
        Triple(it, X - 1, Y - 1)
    }.sortedBy { it.third }
    val lists = sizedArray(W) { mutableListOf<Pair<Int, Int>>() }
    for ((i, X, Y) in XY) {
        val t = Y - lists[X].size
        lists[X].add(i to t)
    }
    val times = sizedIntArray(N, Int.MAX_VALUE)
    var h = 0
    while (lists.all { it.size > h }) {
        val t = lists.maxOf { it[h].second }
        for (x in range(W)) {
            val i = lists[x][h].first
            times[i] = t + h + 1
        }
        h++
    }
    // val XY = times(N) {
    //     val (X, Y) = nextIntList()
    //     Triple(it, X - 1, Y - 1)
    // }.sortedBy { it.third }
    // val H = SegmentTree.RAQ_RmQ(W)
    // H.init(sizedLongArray(W, 0))
    // val lists = sizedArray(W) { mutableListOf<Int>() }
    // var t = 0
    // var h = 0
    // val times = sizedIntArray(N, Int.MAX_VALUE)
    // val queue = ArrayDeque(XY)
    // while (queue.isNotEmpty()) {
    //     val targetY = queue.first().third
    //     val targets = PriorityQueue<Triple<Int, Int, Int>>(compareBy { (_, x, y) -> y - t - lists[x].size })
    //     while (queue.isNotEmpty() && queue.first().third == targetY) {
    //         targets.offer(queue.removeFirst())
    //     }
    //     while (targets.isNotEmpty()) {
    //         val (i, x, y) = targets.poll()
    //         val nt = max(0, y - t - H.query(x, x + 1)).toInt()
    //         H.update(x, 1)
    //         lists[x].add(i)
    //         t += nt
    //         _debug_println("$i ${H.query(0, W)}")
    //         if (H.query(0, W) > h) {
    //             for (j in range(W)) {
    //                 times[lists[j][h]] = t + h + 1
    //             }
    //             h++
    //         }
    //     }
    // }
    val Q = nextInt()
    // _debug_println(times.joinToString(" "))
    repeat(Q) {
        val (T, A) = nextIntList()
        _debug_println("$T $A ${times[A - 1]}")
        println(if (times[A - 1] > T) "Yes" else "No")
    }
}
