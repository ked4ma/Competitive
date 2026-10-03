package com.github.ked4ma.competitive.atcoder.abc478

import com.github.ked4ma.competitive.common.boolean.*
import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.max
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextIntList()
    val A = nextIntList()
    val B = A.sorted()
    var l = N
    var r = -1
    for (i in 0 until N) {
        if (A[i] != B[i]) {
            l = min(l, i)
            r = max(r, i)
        }
    }
    println((r < l || r - l + 1 <= K).toYesNo())

}
