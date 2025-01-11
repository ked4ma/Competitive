package com.github.ked4ma.competitive.atcoder.abc388

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, D) = nextIntList()
    val TL = times(N) {
        val (T, L) = nextIntList()
        T to L
    }
    for (k in 1..D) {
        println(TL.maxOf { (T, L) -> T * (L + k) })
    }
}
