package com.github.ked4ma.competitive.atcoder.abc471

import com.github.ked4ma.competitive.common.input.default.*
import java.util.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (Q, V) = nextIntList()
    val q = PriorityQueue(reverseOrder<Int>())
    repeat(Q) {
        val query = nextIntList()
        val t = query[1]
        when (query[0]) {
            1 -> {
                val w = query[2]
                q.offer(w - t)
            }

            2 -> {
                if (q.isEmpty()) {
                    println(-1)
                } else {
                    val n = min(q.poll() + t, V)
                    println(n)
                }
            }
        }
    }
}
