package com.github.ked4ma.competitive.atcoder.awc0181

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W) = nextIntList()
    var ans = 0
    repeat(H) {
        if (next().all { it == 'o' }) ans++
    }
    println(ans)
}
