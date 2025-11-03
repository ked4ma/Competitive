package com.github.ked4ma.competitive.atcoder.abc395

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.range.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList()
    println(if (range(N - 1).all { A[it] < A[it + 1] }) "Yes" else "No")
}
