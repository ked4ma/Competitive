package com.github.ked4ma.competitive.atcoder.abc431

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, B) = nextIntList()
    println(if (H <= B) 0 else (H - B))
}
