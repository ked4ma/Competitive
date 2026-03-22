package com.github.ked4ma.competitive.atcoder.abc450

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import java.util.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextLongList().let { (n, k) -> n.toInt() to k }
    val A = nextIntList().map { it % K }.toSet()
    val queue = PriorityQueue<Long>()
    queue.addAll(A)
    var max = A.max()
    var ans = LONG_INF
    repeat(A.size) {
        ans = min(ans, max - queue.peek())
        max = queue.poll() + K
        queue.add(max)
    }
    println(ans)
}
