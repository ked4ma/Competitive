package com.github.ked4ma.competitive.training.code

import com.github.ked4ma.competitive.common.array.int.d2.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.min

// make training                    // [_debug_]
// make training-format             // [_debug_]

const val PLATFORM = "atcoder"    // [_debug_]
const val CONTEST = "abc051"      // [_debug_]
const val TASK = "D"              // [_debug_]

//const val PLATFORM = "codeforces" // [_debug_]
//const val CONTEST = "abc214"      // [_debug_]
//const val TASK = "D"              // [_debug_]

fun main() {
    val (N, M) = nextIntList()
    val cost = sized2DIntArray(N, N, INT_INF)
    val ABC = times(M) {
        val (a, b, c) = nextIntList()
        cost[a - 1][b - 1] = c
        cost[b - 1][a - 1] = c
        Triple(a - 1, b - 1, c)
    }
    for (k in 0 until N) {
        for (i in 0 until N) {
            for (j in 0 until N) {
                cost[i][j] = min(cost[i][j], cost[i][k] + cost[k][j])
            }
        }
    }
    var ans = 0
    for ((a, b, c) in ABC) {
        if (cost[a][b] < c) ans++
    }
    println(ans)
}
