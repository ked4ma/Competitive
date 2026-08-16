package com.github.ked4ma.competitive.atcoder.abc471

import com.github.ked4ma.competitive.common.input.default.*
import java.util.*
import kotlin.math.abs

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val pq = PriorityQueue<Int>()
    val nq = PriorityQueue(reverseOrder<Int>())
    nextIntList().forEach { a ->
        if (a >= 0) {
            pq.offer(a)
        } else {
            nq.offer(a)
        }
    }

    var ans = 0L
    var x = 0
    repeat(N) {
        val nx = when {
            pq.isEmpty() -> {
                nq.poll()
            }

            nq.isEmpty() -> {
                pq.poll()
            }

            else -> {
                if (abs(nq.peek() - x) <= abs(pq.peek() - x)) {
                    nq.poll()
                } else {
                    pq.poll()
                }
            }
        }
        ans += abs(nx - x)
        x = nx
    }
    println(ans)
}
