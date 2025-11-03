package com.github.ked4ma.competitive.atcoder.abc411

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.range.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val D = nextIntList()
    for (i in range(N - 1)) {
        var d = 0
        val sj = StringJoiner(" ")
        for (j in i until N - 1) {
            d += D[j]
            sj.add(d.toString())
        }
        println(sj)
    }
}
