package com.github.ked4ma.competitive.atcoder.abc461

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K, M) = nextIntList()
    val cv = times(N) {
        val (c, v) = nextLongList()
        c to v
    }.groupBy({ it.first }, { it.second }).map { it.value.sortedDescending() }
    val q = PriorityQueue(reverseOrder<Long>())
    val q2 = PriorityQueue(reverseOrder<Long>())
    for (l in cv) {
        q.offer(l[0])
        for (i in 1 until l.size) {
            q2.offer(l[i])
        }
    }
    var ans = 0L
    repeat(M) {
        ans += q.poll()
    }
    q2.addAll(q)
    repeat(K - M) {
        ans += q2.poll()
    }
    println(ans)
}
