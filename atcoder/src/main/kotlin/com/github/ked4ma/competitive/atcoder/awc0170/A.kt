package com.github.ked4ma.competitive.atcoder.awc0170

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    var i = 0
    var n = -1L
    repeat(N) {
        val (H, S, _) = nextLongList()
        if (n < H + S) {
            i = it
            n = H + S
        }
    }
    println(i + 1)
}
