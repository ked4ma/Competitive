package com.github.ked4ma.competitive.atcoder.abc462

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val s = next()
    println(s.replace("""[a-z]""".toRegex(), ""))
}
