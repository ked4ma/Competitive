package com.github.ked4ma.competitive.atcoder.abc444

import com.github.ked4ma.competitive.common.boolean.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = next()
    println((N[0] == N[1] && N[1] == N[2]).toYesNo())
}
