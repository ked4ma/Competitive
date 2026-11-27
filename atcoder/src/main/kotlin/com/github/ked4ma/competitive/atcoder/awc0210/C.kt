package com.github.ked4ma.competitive.atcoder.awc0210

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.int.output.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K, X) = nextIntList()
    val A = nextIntList().sortedDescending()
    var i = 0
    while (i < N && A[i] >= X) i++
    if (i < K) {
        println(-1)
        return
    }
    A.slice(0 until K).println("")
}
