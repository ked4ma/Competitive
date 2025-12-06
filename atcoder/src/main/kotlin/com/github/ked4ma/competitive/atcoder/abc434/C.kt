package com.github.ked4ma.competitive.atcoder.abc434

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private fun solve() {
    val (N, H) = nextIntList().let { (N, H) -> N to H.toLong() }
    val data = times(N) {
        nextIntList().let { (t, l, u) -> Triple(t, l.toLong(), u.toLong()) }
    }
    var t = 0
    var l = H
    var u = H
    for ((nt, nl, nu) in data) {
        val minL = maxOf(1, l - (nt - t), nl)
        val maxU = min(u + (nt - t), nu)
        if (minL > maxU) {
            println("No")
            return
        }

        t = nt
        l = minL
        u = maxU
    }
    println("Yes")
}
