package com.github.ked4ma.competitive.atcoder.awc0171

import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val S = next()
    var ans = 0
    for (c in S) {
        ans = max(ans, c - '0')
    }
    println(ans)
}
