package com.github.ked4ma.competitive.atcoder.abc445

import com.github.ked4ma.competitive.common.boolean.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = next()
    println((S[0] == S.last()).toYesNo())
}
