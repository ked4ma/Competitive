package com.github.ked4ma.competitive.atcoder.abc406

import com.github.ked4ma.competitive.common.input.default.*
import java.math.BigDecimal

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextIntList()
    val A = nextLongList()
    var d = BigDecimal(1)
    for (a in A) {
        d *= BigDecimal(a)
        if (d.toString().length > K) {
            d = BigDecimal(1)
        }
    }
    println(d)
}
