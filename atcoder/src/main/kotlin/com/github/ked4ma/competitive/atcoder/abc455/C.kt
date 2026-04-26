package com.github.ked4ma.competitive.atcoder.abc455

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextIntList()
    val A = nextLongList()
    val list = A.groupingBy { it }.eachCount().map { (n, c) -> n * c }.sorted()
    if (list.size <= K) {
        println(0)
        return
    }
    println(list.take(list.size - K).sum())
}
