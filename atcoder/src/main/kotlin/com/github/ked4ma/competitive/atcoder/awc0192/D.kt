package com.github.ked4ma.competitive.atcoder.awc0192

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K, P) = nextLongList().let { (N, K, P) -> Triple(N.toInt(), K.toInt(), P) }
    val AB = times(N) {
        val (A, B) = nextLongList()
        A to B
    }.sortedWith(compareBy({ it.second }, { -it.first }))

    val q = PriorityQueue<Long>()
    var p = 0L
    for (i in 0 until N) {
        val (a, b) = AB[i]
        if (q.size < K) {
            p += a
            q.offer(a)
        } else {
            p += a
            q.offer(a)
            p -= q.poll()
        }
        if (q.size == K && p >= P) {
            println(b)
            return
        }
    }
    println(-1)
}
