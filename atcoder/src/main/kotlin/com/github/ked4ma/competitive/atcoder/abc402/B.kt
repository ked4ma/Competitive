package com.github.ked4ma.competitive.atcoder.abc402

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val Q = nextInt()
    val queue = ArrayDeque<Int>()
    repeat(Q) {
        val query = nextIntList()
        when (query[0]) {
            1 -> queue.addLast(query[1])
            2 -> println(queue.removeFirst())
        }
    }
}
