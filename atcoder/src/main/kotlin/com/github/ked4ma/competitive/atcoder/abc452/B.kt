package com.github.ked4ma.competitive.atcoder.abc452

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W) = nextIntList()
    repeat(H) { h ->
        if (h == 0 || h == H - 1) {
            println("#".repeat(W))
        } else {
            println("#${".".repeat(W - 2)}#")
        }
    }
}
