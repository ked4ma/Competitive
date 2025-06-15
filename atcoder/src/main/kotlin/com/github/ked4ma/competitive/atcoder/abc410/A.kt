package com.github.ked4ma.competitive.atcoder.abc410

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList()
    val K = nextInt()
    println(A.count { it >= K })
}
