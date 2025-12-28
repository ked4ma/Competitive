package com.github.ked4ma.competitive.atcoder.abc438

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val S = next()
    val T = next()
    var ans = INT_INF
    for (i in 0 until N - M + 1) {
        var n = 0
        val s = S.substring(i until M + i)
        _debug_println(s)
        for (j in 0 until M) {
            val a = s[j] - '0'
            val b = T[j] - '0'
            n += if (a >= b) a - b else 10 - b + a
        }
        ans = min(ans, n)
    }
    println(ans)
}
