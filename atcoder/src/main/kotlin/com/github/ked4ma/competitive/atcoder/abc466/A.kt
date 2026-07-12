package com.github.ked4ma.competitive.atcoder.abc466

import com.github.ked4ma.competitive.common.boolean.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val X = nextIntList()
    println(X.all { it < 0 }.toYesNo())
}
