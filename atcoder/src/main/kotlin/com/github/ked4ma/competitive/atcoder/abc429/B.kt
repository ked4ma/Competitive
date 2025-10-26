package com.github.ked4ma.competitive.atcoder.abc429

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val A = nextIntList()
    val sum = A.sum()
    val set = A.toSet()
    println(if ((sum - M) in set) "Yes" else "No")
}
