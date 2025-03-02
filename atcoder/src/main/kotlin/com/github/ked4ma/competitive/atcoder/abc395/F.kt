package com.github.ked4ma.competitive.atcoder.abc395

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.max
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, X) = nextIntList().let { (N, X) -> N to X.toLong() }
    val UD = times(N) {
        val (U, D) = nextLongList()
        U to D
    }
    val maxH = UD.minOf { (u, d) -> u + d }

    fun check(h: Long, ranges: List<Pair<Long, Long>>): Boolean {
        var (l, r) = ranges[0]
        for (i in 1 until N - 1) {
            val l2 = max(0, l - X)
            val r2 = min(h, r + X)
            val (a, b) = ranges[i]
            l = max(a, l2)
            r = min(b, r2)
            if (l > r) {
                return false
            }
        }
        return true
    }

    var ok = 0L
    var ng = maxH + 1
    while (ok + 1 < ng) {
        val h = (ok + ng) / 2
        val ranges = UD.map { (u, d) ->
            max(0, h - d) to min(h, u)
        }
        _debug_println(ranges)
        if (check(h, ranges)) {
            ok = h
        } else {
            ng = h
        }
    }
    _debug_println(ok)
    println(UD.sumOf { (u, d) -> u + d - ok })
}
