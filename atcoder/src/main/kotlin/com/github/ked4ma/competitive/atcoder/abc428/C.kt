package com.github.ked4ma.competitive.atcoder.abc428

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    var h = 0
    var minusCount = 0
    val queue = ArrayDeque<Char>()
    val Q = nextInt()
    repeat(Q) {
        val query = nextList()
        when (query[0]) {
            "1" -> {
                val c = query[1][0]
                queue.add(c)
                when (c) {
                    '(' -> {
                        h++
                    }

                    ')' -> {
                        h--
                        if (h == -1) minusCount++
                    }
                }
            }

            "2" -> {
                val c = queue.removeLast()
                when (c) {
                    '(' -> {
                        h--
                    }

                    ')' -> {
                        h++
                        if (h == 0) minusCount--
                    }
                }
            }
        }
        _debug_println(queue)
        println(if (h == 0 && minusCount == 0) "Yes" else "No")
    }
}
