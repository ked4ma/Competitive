package com.github.ked4ma.competitive.atcoder.abc407

import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.abs

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (A, B) = nextIntList()
    val C = A / B
    val D = C + 1
    val c = abs(C - A.toDouble() / B)
    val d = abs(D - A.toDouble() / B)
    println(if (c < d) C else D)
}
