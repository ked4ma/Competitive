package com.github.ked4ma.competitive.atcoder.abc407

import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.abs

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (X, Y) = nextIntList()
    var ans = 0
    for (i in 1..6) {
        for (j in 1..6) {
            if (i + j >= X || abs(i - j) >= Y) ans++
        }
    }
    println("%.12f".format(ans.toDouble() / 36))
}
