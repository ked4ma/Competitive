package com.github.ked4ma.competitive.atcoder.abc392

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (A1, A2, A3) = nextIntList()
    println(if (A1 * A2 == A3 || A2 * A3 == A1 || A3 * A1 == A2) "Yes" else "No")
}
