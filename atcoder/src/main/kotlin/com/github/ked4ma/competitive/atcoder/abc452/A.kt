package com.github.ked4ma.competitive.atcoder.abc452

import com.github.ked4ma.competitive.common.boolean.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (M, D) = nextIntList()
    println(
        (M to D in listOf(
            1 to 7,
            3 to 3,
            5 to 5,
            7 to 7,
            9 to 9,
        )).toYesNo()
    )
}
