package com.github.ked4ma.competitive.atcoder.abc485

import com.github.ked4ma.competitive.common.boolean.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (A, B) = nextIntList()
    println(((A * B) > 0).toYesNo())
}
