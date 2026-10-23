package com.github.ked4ma.competitive.atcoder.awc0185

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W) = nextIntList()
    repeat(H) {
        println(next().count { it == '.' })
    }
}
