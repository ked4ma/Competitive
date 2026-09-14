package com.github.ked4ma.competitive.atcoder.awc0156

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextIntList()
    val A = nextLongList().sorted()
    val d = (0 until N - 1).map { A[it + 1] - A[it] }.withIndex().sortedBy { (_, v) -> v }.dropLast(K - 1)
    println(d.sumOf { it.value })

}
