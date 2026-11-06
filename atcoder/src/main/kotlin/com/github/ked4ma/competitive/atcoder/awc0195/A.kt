package com.github.ked4ma.competitive.atcoder.awc0195

import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    repeat(N) {
        val (a, b) = nextIntList()
        println(max(0, a - b))
    }
}
