package com.github.ked4ma.competitive.codeforces.`2180`

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val t = nextInt()
    times(t) {
        solve()
    }.let {
        println(it.joinToString("\n"))
    }
}

private fun solve(): Int {
    val n = nextInt()
    val x = nextIntList()
    var prev = 0 to INT_INF
    var ans = 0
    for (i in 1 until n) {
        if (x[i] <= prev.first + x[i - 1]) {
            prev = 0 to INT_INF
            ans--
        }
        val d = x[i] - x[i - 1]
        val cur = max(0, d - prev.second) to d - prev.first
        prev = cur
        ans++
        _debug_println("$i: $cur $ans")
    }
    return ans
}
