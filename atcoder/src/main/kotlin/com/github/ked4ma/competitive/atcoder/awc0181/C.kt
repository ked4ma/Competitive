package com.github.ked4ma.competitive.atcoder.awc0181

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.long.bound.*
import com.github.ked4ma.competitive.common.list.long.cumlative.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, C) = nextLongList().let { (N, C) -> N.toInt() to C }
    val A = nextLongList().sorted()
    val cum = A.cumulativeSum()
    println(min(N, cum.upperBound(C)))
}
