package com.github.ked4ma.competitive.atcoder.awc0151

import com.github.ked4ma.competitive.common.boolean.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M, K) = nextLongList()
    val A = times(M.toInt()) { nextLong() }
    println((A.sum() <= N * K).toYesNo())
}
