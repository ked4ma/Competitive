package com.github.ked4ma.competitive.atcoder.abc458

import com.github.ked4ma.competitive.common.debug._debug_println
import com.github.ked4ma.competitive.common.input.default.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val X = nextInt()
    val upper = PriorityQueue<Int>()
    val lower = PriorityQueue(reverseOrder<Int>())

    fun add(x: Int) {
        val u = upper.peek()
        val l = if (lower.isNotEmpty()) lower.peek() else 0
        if (x >= u) {
            upper.offer(x)
        } else if (x <= l) {
            lower.offer(x)
        } else {
            upper.offer(x)
        }
    }

    var n = 1
    fun balance() {
        while (upper.size > (n + 1) / 2) {
            lower.offer(upper.poll())
        }
        while (lower.size > n / 2) {
            upper.offer(lower.poll())
        }
    }

    upper.offer(X)
    val Q = nextInt()
    repeat(Q) {
        val (A, B) = nextIntList()
        add(A)
        add(B)
        n += 2
        balance()
        println(upper.peek())
        _debug_println("-----")
        _debug_println(upper)
        _debug_println(lower)
    }
}
