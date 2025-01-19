package com.github.ked4ma.competitive.atcoder.abc389

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.long.pow.*
import kotlin.math.pow
import kotlin.math.sqrt

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val R = nextLong()
    fun upperY(x: Long): Double {
        // (x - 0.5 - R)^2 + y^2 = R^2
        return sqrt(R.pow(2) - (x - 0.5 - R).pow(2)) + 0.5
    }

    var ans = 0L
    for (x in 1 until R) {
        _debug_println("$x: ${upperY(x)}")
        ans += upperY(x).toLong()
    }
    _debug_println(ans)
    println(ans * 4 + 1)
}
