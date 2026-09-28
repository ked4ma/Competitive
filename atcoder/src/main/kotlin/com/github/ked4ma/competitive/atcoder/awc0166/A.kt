package com.github.ked4ma.competitive.atcoder.awc0166

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextLongList()
    val aMin = A.min()
    println(A.sumOf { it - aMin })
}
