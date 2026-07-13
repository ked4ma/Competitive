package com.github.ked4ma.competitive.atcoder.arc224

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private fun solve() {
    val N = nextLong()
    var l = 0L
    var r = 1_000_000_001L
    while (l + 1 < r) {
        val m = (l + r) / 2
        if (m * m <= N) {
            l = m
        } else {
            r = m
        }
    }
    _debug_println("l: $l")
    var ans = 2L * l * (l - 1)
    _debug_println("ans: $ans")
    val rem = N - l * l
    _debug_println("rem: $rem")
    if (rem in 1..l) {
        ans += 2 * rem - 1
    } else if (rem in l + 1..2 * l) {
        ans += 2 * rem - 2
    }
    println(ans)
}
