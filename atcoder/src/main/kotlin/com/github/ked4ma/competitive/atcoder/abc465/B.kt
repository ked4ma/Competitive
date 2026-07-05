package com.github.ked4ma.competitive.atcoder.abc465

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.component.*
import kotlin.math.max
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (X, Y, L, R, A, B) = nextIntList()
    var ans = (B - A) * Y
    val a = max(L, A)
    val b = min(R, B)
    if (a <= b) ans += (b - a) * (X - Y)
    println(ans)
}
