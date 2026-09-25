package com.github.ked4ma.competitive.atcoder.awc0165

import com.github.ked4ma.competitive.common.array.long.output.*
import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val A = nextLongList().toLongArray()
    val B = nextLongList()
    val C = nextIntList().map { it - 1 }
    for (c in C) {
        A[c] = max(0, A[c] - B[c])
        if (c + 1 < N) {
            A[c + 1] += A[c]
        }
        A[c] = 0
    }
    A.println(" ")
}
