package com.github.ked4ma.competitive.atcoder.abc400

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextLong()
    var a = 2L
    var ans = 0L
    while (a <= N) {
        val b2 = N / a
        var l = 1L
        var r = 1000000001L
        while (l + 1 < r) {
            val m = (l + r) / 2
            if (m * m <= b2) {
                l = m
            } else {
                r = m
            }
        }
        ans += l - l / 2
        _debug_println("$a $l ${l - l / 2}")
        a *= 2
    }
    println(ans)
}
