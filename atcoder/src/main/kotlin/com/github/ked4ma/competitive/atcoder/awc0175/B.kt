package com.github.ked4ma.competitive.atcoder.awc0175

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W, K) = nextIntList()
    val sb = StringBuilder()
    repeat(H) {
        sb.append(next()[K - 1])
    }
    println(sb)
}
