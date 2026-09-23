package com.github.ked4ma.competitive.atcoder.awc0163

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.div.ceil.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M, K) = nextLongList()
    val A = nextLongList()
    val x = A.sumOf { a -> a.ceilDiv(K) }
    println(max(0, x - M))
}
