package com.github.ked4ma.competitive.atcoder.abc397

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextLong()
    var d = 1L
    while (d * d * d <= N) {
        if (N % d != 0L) {
            d++
            continue
        }
        val a = 3
        val b = 3 * d
        val c = d * d - N / d
        var l = 0L
        var r = 1000000000L
        while (l + 1 < r) {
            val m = (l + r) / 2
            if (a * m * m + b * m + c <= 0) {
                l = m
            } else {
                r = m
            }
        }
        if (l > 0 && a * l * l + b * l + c == 0L) {
            println("${d + l} $l")
            return
        }
        d++
    }
    println(-1)
}
