package com.github.ked4ma.competitive.atcoder.abc451

import com.github.ked4ma.competitive.common.input.default.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val Q = nextInt()
    val queue = PriorityQueue<Int>()
    repeat(Q) {
        val (q, h) = nextIntList()
        when (q) {
            1 -> {
                queue.add(h)
            }

            2 -> {
                while (queue.isNotEmpty() && queue.peek() <= h) {
                    queue.poll()
                }
            }
        }
        println(queue.size)
    }
}
