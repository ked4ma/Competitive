package com.github.ked4ma.competitive.atcoder.abc453

import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.abs

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (T, X) = nextIntList()
    val A = nextIntList()
    var a = -1000
    for (i in 0..T) {
        if (abs(a - A[i]) >= X) {
            a = A[i]
            println("$i $a")
        }
    }
}
