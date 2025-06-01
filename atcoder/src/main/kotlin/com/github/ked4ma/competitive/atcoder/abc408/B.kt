package com.github.ked4ma.competitive.atcoder.abc408

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList()

    val ans = A.toSet().toList().sorted()
    println(ans.size)
    println(ans.joinToString(" "))
}
