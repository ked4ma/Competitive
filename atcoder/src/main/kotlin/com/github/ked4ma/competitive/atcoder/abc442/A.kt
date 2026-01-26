package com.github.ked4ma.competitive.atcoder.abc442

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = next()
    println(S.count { it == 'i' || it == 'j' })
}
