package com.github.ked4ma.competitive.atcoder.abc441

import com.github.ked4ma.competitive.common.boolean.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (P, Q) = nextIntList().map { it - 1 }
    val (X, Y) = nextIntList().map { it - 1 }
    println((X in P until P + 100 && Y in Q until Q + 100).toYesNo())
}
