package com.github.ked4ma.competitive.atcoder.abc467

import com.github.ked4ma.competitive.common.boolean.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W) = nextLongList()
    println((W * 100 * 100 >= 25L * H * H).toYesNo())
}
