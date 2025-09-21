package com.github.ked4ma.competitive.atcoder.abc424

import com.github.ked4ma.competitive.common.array.int.d2.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M, K) = nextIntList()
    val count = sized2DIntArray(N, M + 1, 0)
    val ans = mutableListOf<Int>()
    repeat(K) {
        val (A, B) = nextIntList().map { it - 1 }
        if (count[A][B] == 0) {
            count[A][B] = 1
            count[A][M]++
            if (count[A][M] == M) ans.add(A + 1)
        }
    }
    println(ans.joinToString(" "))
}

