package com.github.ked4ma.competitive.atcoder.abc407

import com.github.ked4ma.competitive.common.input.default.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    val ans = mutableListOf<Long>()
    repeat(T) {
        ans.add(solve())
    }
    println(ans.joinToString("\n"))
}

fun solve(): Long {
    val N = nextInt()
    val q = PriorityQueue<Long>(reverseOrder())
    var i = 0
    var j = 1
    var ans = 0L
    while (j < 2 * N) {
        repeat(j - i) {
            q.add(nextLong())
        }
        ans += q.poll()
        i = j
        j += 2
    }
    nextLong()
    return ans
}
