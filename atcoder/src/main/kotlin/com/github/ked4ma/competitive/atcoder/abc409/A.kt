package com.github.ked4ma.competitive.atcoder.abc409

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.range.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val T = nextCharArray()
    val A = nextCharArray()
    println(if (range(N).any { i -> T[i] == 'o' && A[i] == 'o' }) "Yes" else "No")
}
