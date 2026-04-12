package com.github.ked4ma.competitive.atcoder.abc453

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val S = next()
    println(S.replace("^o*".toRegex(), ""))
}
