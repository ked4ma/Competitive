package com.github.ked4ma.competitive.atcoder.abc413

import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val Q = nextInt()
    val queue = ArrayDeque<Pair<Long, Long>>()
    repeat(Q) {
        val query = nextLongList()
        when (query[0]) {
            1L -> {
                val c = query[1]
                val x = query[2]
                queue.addLast(x to c)
            }

            2L -> {
                var k = query[1]
                var ans = 0L
                while (k > 0) {
                    val (x, c) = queue.removeFirst()
                    val m = min(k, c)
                    ans += x * m
                    if (c - m > 0) {
                        queue.addFirst(x to c - m)
                    }
                    k -= m
                }
                println(ans)
            }
        }
    }
}
