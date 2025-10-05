package com.github.ked4ma.competitive.atcoder.abc426

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val os = listOf("Ocelot", "Serval", "Lynx")
    val (X, Y) = nextList().map { os.indexOf(it) }
    println(if (X >= Y) "Yes" else "No")
}
