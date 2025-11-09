package com.github.ked4ma.competitive.atcoder.abc431

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M, K) = nextIntList()
    val H = ArrayDeque(nextIntList().sorted())
    val B = ArrayDeque(nextIntList().sorted())
    var cnt = 0
    while (H.isNotEmpty() && B.isNotEmpty()) {
        val h = H.removeFirst()
        while (B.isNotEmpty() && B.first() < h) {
            B.removeFirst()
        }
        if (B.isEmpty()) break
        cnt++
        B.removeFirst()
    }
    println(if (cnt >= K) "Yes" else "No")
}
