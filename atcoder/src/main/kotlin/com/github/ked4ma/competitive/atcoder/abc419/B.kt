package com.github.ked4ma.competitive.atcoder.abc419

import com.github.ked4ma.competitive.common.input.default.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val Q = nextInt()
    val queue = PriorityQueue<Int>()

    repeat(Q) {
        val q = nextIntList()
        when (q[0]) {
            1 -> queue.offer(q[1])
            2 -> println(queue.poll())
        }
    }
}
