package com.github.ked4ma.competitive.atcoder.abc414

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val X = nextLongList().sorted()
    val D = X.windowed(2, 1).map { (l, r) -> r - l }
    println(D.sorted().take(N - M).sum())
}
