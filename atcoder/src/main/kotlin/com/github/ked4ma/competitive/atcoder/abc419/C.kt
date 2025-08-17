package com.github.ked4ma.competitive.atcoder.abc419

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import kotlin.math.max
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    var minR = LONG_INF
    var minC = LONG_INF
    var maxR = 0L
    var maxC = 0L
    repeat(N) {
        val (R, C) = nextLongList()
        minR = min(minR, R)
        maxR = max(maxR, R)
        minC = min(minC, C)
        maxC = max(maxC, C)
    }
    println(max((maxR - minR + 1) / 2, (maxC - minC + 1) / 2))
}
