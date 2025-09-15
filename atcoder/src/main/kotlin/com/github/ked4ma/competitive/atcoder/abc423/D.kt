package com.github.ked4ma.competitive.atcoder.abc423

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*
import java.util.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextLongList()
    val G = times(N.toInt()) {
        val (A, B, C) = nextLongList()
        Triple(A, B, C)
    }
    var sum = 0L
    var t = 0L
    val queue = PriorityQueue<Pair<Long, Long>>(compareBy { it.first })
    val ans = mutableListOf<Long>()
    for ((A, B, C) in G) {
        t = max(t, A)
        while (queue.isNotEmpty() && queue.peek().first <= t) {
            val (_, c) = queue.poll()
            sum -= c
        }
        while (sum + C > K) {
            val (t2, c) = queue.poll()
            t = t2
            sum -= c
        }
        ans.add(t)
        queue.add(t + B to C)
        sum += C
    }
    println(ans.joinToString("\n"))
}
