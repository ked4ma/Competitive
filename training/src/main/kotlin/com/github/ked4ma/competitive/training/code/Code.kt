package com.github.ked4ma.competitive.training.code

import com.github.ked4ma.competitive.common.array.long.d2.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.mod.*

// make training                    // [_debug_]
// make training-format             // [_debug_]

const val PLATFORM = "atcoder"    // [_debug_]
const val CONTEST = "abc135"      // [_debug_]
const val TASK = "D"              // [_debug_]

//const val PLATFORM = "codeforces" // [_debug_]
//const val CONTEST = "abc214"      // [_debug_]
//const val TASK = "D"              // [_debug_]

fun main() {
    val MOD = MOD10e9_7
    val S = nextCharArray()
    val n = S.size
    val dp = sized2DLongArray(n + 1, 13, 0)
    dp[0][0] = 1
    for (i in 0 until n) {
        val list = buildList {
            if (S[i] != '?') {
                add(S[i] - '0')
            } else {
                (0..9).forEach(::add)
            }
        }
        for (j in 0 until 13) {
            for (k in list) {
                dp[i + 1][(j * 10 + k) % 13] += dp[i][j]
                dp[i + 1][(j * 10 + k) % 13] %= MOD
            }
        }
    }
    println(dp.last()[5])
}
