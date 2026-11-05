package com.github.ked4ma.competitive.atcoder.awc0194

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*
import java.util.*

fun main() {
    val (N, M) = nextIntList()
    val AB = times(N) {
        val (A, B) = nextLongList()
        A to B
    }.sortedByDescending { it.first }
    val C = nextLongList().sortedDescending()
    val q = PriorityQueue<Long>(compareByDescending { it })
    var i = 0
    var ans = 0L
    for (c in C) {
        while (i < N && AB[i].first >= c) {
            q.offer(AB[i].second)
            i++
        }
        if (q.isEmpty()) {
            println(-1)
            return
        }
        ans += q.poll()
    }
    println(ans)
}
