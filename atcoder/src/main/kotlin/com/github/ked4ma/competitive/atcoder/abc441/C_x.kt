package com.github.ked4ma.competitive.atcoder.abc441

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K, X) = nextLongList().let { (N, K, X) -> Triple(N.toInt(), K.toInt(), X) }
    val A = nextLongList().sorted().take(K).sortedDescending()
    _debug_println(A)
    var i = 0
    var a = 0L
    while (i < K && a < X) {
        a += A[i]
        i++
    }
    if (a < X) {
        println(-1)
        return
    }
    println(i + N - K)
}
