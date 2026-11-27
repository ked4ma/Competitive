package com.github.ked4ma.competitive.atcoder.awc0210

import com.github.ked4ma.competitive.common.boolean.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextIntList()
    val S = next()
    println((S.count { it == '7' } >= K).toYesNo())
}
