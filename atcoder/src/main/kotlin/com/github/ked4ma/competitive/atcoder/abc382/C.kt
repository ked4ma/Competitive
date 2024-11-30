package com.github.ked4ma.competitive.atcoder.abc382

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val A = nextIntList()
    val B = nextIntList()
        .withIndex()
        .sortedByDescending { it.value }
    var ai = 0
    val ans = sizedIntArray(M, -1)
    for ((bi, b) in B) {
        while (ai < N && A[ai] > b) ai++
        if (ai < N) {
            ans[bi] = ai + 1
        }
    }
    println(ans.joinToString("\n"))
}
