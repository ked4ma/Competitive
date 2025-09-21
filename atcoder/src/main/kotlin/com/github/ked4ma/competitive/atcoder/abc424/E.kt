package com.github.ked4ma.competitive.atcoder.abc424

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private fun solve() {
    val (N, K, X) = nextIntList()
    val A = nextDoubleList()

    val queue = PriorityQueue<Pair<Double, Long>>(compareByDescending { it.first })
    for (a in A) {
        queue.offer(a to 1)
    }
    _debug_println(queue)
    var rem = K.toLong()
    while (rem > 0) {
        val (a, c) = queue.poll()
        if (rem >= c) {
            queue.offer(a / 2 to 2 * c)
            rem -= c
        } else {
            queue.offer(a / 2 to 2 * rem)
            queue.offer(a to c - rem)
            rem = 0
        }
    }
    _debug_println(queue)
    rem = X.toLong()
    while (queue.isNotEmpty()) {
        val (a, c) = queue.poll()
        if (rem <= c) {
            println("%.10f".format(a))
            return
        }
        rem -= c
    }
}
