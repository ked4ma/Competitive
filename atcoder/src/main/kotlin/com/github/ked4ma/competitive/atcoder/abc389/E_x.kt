package com.github.ked4ma.competitive.atcoder.abc389

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextLongList()
    val P = nextLongList()
    var ok = 0L
    var ng = M + 1
    var ans = 0L
    while (ok + 1 < ng) {
        val m = (ok + ng) / 2
        var cost = 0L
        var costD = 0.0
        var cnt = 0L
        for (p in P) {
            val j = (m / p + 1) / 2
            cost += p * j * j
            costD += p.toDouble() * j * j
            cnt += j
        }
        for (p in P) {
            val j = (m / p + 1) / 2
            val x = (2 * j + 1) * p
            if (x == m + 1 && cost + m + 1 <= M) {
                cost += m + 1
                costD += m + 1
                cnt++
            }
        }
        if (costD < Long.MAX_VALUE && cost <= M) {
            ok = m
            ans = cnt
        } else {
            ng = m
        }
    }
    println(ans)
}
