package com.github.ked4ma.competitive.atcoder.awc0171

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W) = nextIntList()
    var ans = 0
    var n = -1
    repeat(H) {
        val m = nextCharArray().count { it == '.' }
        if (m > n) {
            ans = it + 1
            n = m
        }
    }
    println(ans)
}
