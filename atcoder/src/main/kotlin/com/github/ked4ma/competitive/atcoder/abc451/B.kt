package com.github.ked4ma.competitive.atcoder.abc451

import com.github.ked4ma.competitive.common.array.int.d2.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val arr = sized2DIntArray(M, 2)
    repeat(N) {
        val (a, b) = nextIntList().map { it - 1 }
        arr[a][0]++
        arr[b][1]++
    }
    for (i in 0 until M) {
        println(arr[i][1] - arr[i][0])
    }
}
