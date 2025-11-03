package com.github.ked4ma.competitive.atcoder.abc400

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.long.pow.*
import com.github.ked4ma.competitive.common.repeat.range.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val INF = 1000000000L
    val (N, M) = nextIntList().let { (N, M) -> N.toLong() to M }
    var sum = 0L
    var ok = true
    for (i in range(M + 1)) {
        sum += N.pow(i)
        if (sum > INF) {
            ok = false
            break
        }
    }
    if (sum > INF) {
        ok = false
    }
    if (ok) {
        println(sum)
    } else {
        println("inf")
    }
}
