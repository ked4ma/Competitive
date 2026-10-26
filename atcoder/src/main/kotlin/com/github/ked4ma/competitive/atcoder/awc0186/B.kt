package com.github.ked4ma.competitive.atcoder.awc0186

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.div.ceil.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (A, B, C) = nextIntList()
    println(max(0, C - A).ceilDiv(B))
}
