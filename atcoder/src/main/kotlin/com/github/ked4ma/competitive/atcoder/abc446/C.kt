package com.github.ked4ma.competitive.atcoder.abc446

import com.github.ked4ma.competitive.common.debug._debug_println
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private fun solve() {
    val (N, D) = nextIntList()
    val A = nextIntList()
    val B = nextIntList()
    val queue = ArrayDeque<Pair<Int, Int>>()
    repeat(N) { i ->
        queue.addLast(A[i] to i)
        var b = B[i]
        while (b > 0) {
            val (a, j) = queue.removeFirst()
            if (b >= a) {
                b -= a
            } else {
                queue.addFirst(a - b to j)
                b = 0
            }
        }
        while (queue.isNotEmpty() && i - queue.first().second >= D) {
            queue.removeFirst()
        }
        _debug_println(queue)
    }
    println(queue.sumOf { it.first })
}
