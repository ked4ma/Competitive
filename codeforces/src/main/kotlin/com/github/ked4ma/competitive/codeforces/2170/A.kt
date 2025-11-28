package com.github.ked4ma.competitive.codeforces.`2170`

import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val t = nextInt()
    repeat(t) {
        solve()
    }
}

private fun solve() {
    val n = nextInt()
    val dirs = listOf(
        1 to 0,
        -1 to 0,
        0 to 1,
        0 to -1,
    )

    var ans = 0
    fun value(h: Int, w: Int) = (h - 1) * n + w
    for (h in 1..n) {
        for (w in 1..n) {
            var sum = value(h, w)
            for ((dh, dw) in dirs) {
                val nh = h + dh
                val nw = w + dw
                if (nh in 1..n && nw in 1..n) {
                    sum += value(nh, nw)
                }
            }
            ans = max(ans, sum)
        }
    }
    println(ans)
}
