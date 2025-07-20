package com.github.ked4ma.competitive.atcoder.abc415

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList()
    val X = nextInt()

    println(if (X in A) "Yes" else "No")
}
