package com.github.ked4ma.competitive.atcoder.awc0156

import com.github.ked4ma.competitive.common.array.int.output.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val A = nextIntList().toIntArray()
    repeat(M) {
        val (B, C) = nextIntList()
        if (A[B - 1] >= C) A[B - 1] -= C
    }
    A.println(" ")
}
