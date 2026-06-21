package com.github.ked4ma.competitive.atcoder.abc463

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextIntList()
    val LR = times(N) {
        val (L, R) = nextIntList()
        L to R
    }.sortedWith(compareBy({ it.second }, { it.first }))

    fun schedule(d: Int): Int {
        var res = 1
        var (l, r) = LR[0]
        for (i in 1 until N) {
            val (l2, r2) = LR[i]
            if (r + d <= l2) {
                res++
                l = l2
                r = r2
            }
        }
        return res
    }

    var ok = 0
    var ng = INT_INF
    while (ok + 1 < ng) {
        val m = (ok + ng) / 2
        if (schedule(m) >= K) {
            ok = m
        } else {
            ng = m
        }
    }
    if (ok == 0) ok = -1
    println(ok)
}
