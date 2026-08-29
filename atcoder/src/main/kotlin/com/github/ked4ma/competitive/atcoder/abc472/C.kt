package com.github.ked4ma.competitive.atcoder.abc472

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M, K) = nextLongList().let { (N, M, K) -> Triple(N.toInt(), M.toInt(), K) }
    val A = nextLongList()

    val q = ArrayDeque<Int>()
    var sum = 0L
    for (i in 0 until N) {
        if (q.isNotEmpty() && q.first() == i) {
            sum -= A[q.removeFirst() - M]
        }
        _debug_println(sum)
        if (sum + A[i] <= K) {
            println("Yes")
            sum += A[i]
            q.add(i + M)
        } else {
            println("No")
        }
    }
}
