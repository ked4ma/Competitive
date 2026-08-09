package com.github.ked4ma.competitive.atcoder.arc226

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
    val (N, M) = nextIntList()
    val A = nextLongList()

    var x = 0L
    var ans = 0L
    for (i in (0 until M).reversed()) {
        val a = A[i]
        if (a - 2 * x >= 0) {
            val b = a - 2 * x
            val c = (b + N - 1) / N
            ans += (1L shl i) * c
            x = (N - b % N) % N
            _debug_println("${1L shl i}: $c ($x)")
        } else {
            x = x * 2 - a
        }
    }
    println(ans)
}
