package com.github.ked4ma.competitive.atcoder.awc0163

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    var (L, W) = nextLongList()
    var ans = 0
    while (L > W) {
        L = (L + 1) / 2
        ans++
    }
    println(ans)
}
