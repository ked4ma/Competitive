package com.github.ked4ma.competitive.atcoder.abc435

import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList()
    var i = A[0]
    for (j in 1 until N) {
        if (j >= i) {
            println(j)
            return
        }
        i = max(i, j + A[j])
    }
    println(N)
}
