package com.github.ked4ma.competitive.atcoder.awc0186

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.array.long.d1.chmin.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val X = nextLongList().sorted()
    val RC = times(M) {
        val (R, C) = nextLongList()
        R to C
    }.sortedBy { it.first }
    val dist = sizedLongArray(N + 1, LONG_INF)
    dist[0] = 0
    for (u in 0 until N) {
        val d = dist[u]
        var j = 0
        for ((r, c) in RC) {
            while (j < N && X[j] <= X[u] + r * 2) j++
            dist.chmin(j, d + c)
        }
    }
    _debug_println(dist)
    println(dist.last())
}
