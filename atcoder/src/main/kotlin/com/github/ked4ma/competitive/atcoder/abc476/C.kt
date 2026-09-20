package com.github.ked4ma.competitive.atcoder.abc476

import com.github.ked4ma.competitive.common.input.default.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList()
    val q = PriorityQueue<Int>()
    q.add(A[0])
    q.add(A[1])
    for (i in 2 until N) {
        q.add(A[i])
        while (q.size > 3) {
            q.poll()
        }
        println(q.peek())
    }
}
