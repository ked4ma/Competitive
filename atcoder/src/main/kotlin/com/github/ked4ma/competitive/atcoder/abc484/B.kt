package com.github.ked4ma.competitive.atcoder.abc484

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val K = nextInt()
    val A = nextIntList().sorted()
    println(if (A[K - 1] == 9) A[0] else -1)
}
