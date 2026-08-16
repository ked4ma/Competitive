package com.github.ked4ma.competitive.atcoder.abc471

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val ans = times(N) {
        next().lowercase()
    }.groupingBy { it }.eachCount().maxOf { it.value }
    println(ans)
}
