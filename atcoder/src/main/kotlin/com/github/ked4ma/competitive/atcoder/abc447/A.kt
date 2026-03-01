package com.github.ked4ma.competitive.atcoder.abc447

import com.github.ked4ma.competitive.common.boolean.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    println(((N + 1) / 2 >= M).toYesNo())
}
