package com.github.ked4ma.competitive.atcoder.abc450

import com.github.ked4ma.competitive.common.array.int.d2.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val C = sized2DIntArray(N, N, INT_INF)
    for (i in 0 until N - 1) {
        nextIntList().forEachIndexed { j, c ->
            C[i][j + i + 1] = c
        }
    }
    for (i in 0 until N) {
        for (j in i + 2 until N) {
            for (k in i + 1 until j) {
                if (C[i][k] + C[k][j] < C[i][j]) {
                    println("Yes")
                    return
                }
            }
        }
    }
    println("No")
}
