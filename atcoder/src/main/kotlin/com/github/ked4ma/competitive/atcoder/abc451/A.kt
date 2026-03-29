package com.github.ked4ma.competitive.atcoder.abc451

import com.github.ked4ma.competitive.common.boolean.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = next()
    println((S.length % 5 == 0).toYesNo())
}
