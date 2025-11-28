package com.github.ked4ma.competitive.codeforces.`2170`

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.int.bound.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val t = nextInt()
    repeat(t) {
        solve()
    }
}

private fun solve() {
    var n = nextInt()
    val b = nextIntList().sorted()
    val bMax = b.max()
    val queue = PriorityQueue<Int>()
    for (i in 1..bMax) {
        val l = b.lowerBound(i)
        queue.offer(b.lastIndex - l + 1)
    }
    _debug_println(queue)
    n -= queue.size
    while (n > 0) {
        val a = queue.poll()
        if (a > 1) {
            queue.offer(a - 1)
            n--
        }
    }
    _debug_println(queue)
    println(queue.max())
}
