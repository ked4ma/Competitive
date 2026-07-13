package com.github.ked4ma.competitive.atcoder.arc224

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.combimation.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private fun solve() {
    _debug_println("-----")
    val (N, K) = nextLongList()
    var k = K - 1
    var c = 1L
    var ans = 0L
    while (k > 0 && N >= c) {
        var m = combination(N, c)
        while (k > 0 && m > 0) {
            ans += k.toString().length * c
            k--
            m--
        }
        c++
    }
    if (k > 0) {
        println(-1)
        return
    }
    println(ans)
}
