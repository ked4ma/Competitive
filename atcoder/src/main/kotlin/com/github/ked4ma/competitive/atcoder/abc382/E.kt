package com.github.ked4ma.competitive.atcoder.abc382

import com.github.ked4ma.competitive.common.array.double.d1.*
import com.github.ked4ma.competitive.common.array.double.d2.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.range.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, X) = nextIntList()
    val P = nextDoubleList().map { it / 100 }
    val pArr = sized2DDoubleArray(N + 1, N + 1, 0.0)
    pArr[0][0] = 1.0
    for (i in range(N)) {
        for (j in 0..i) {
            pArr[i + 1][j] += pArr[i][j] * (1 - P[i])
            pArr[i + 1][j + 1] += pArr[i][j] * P[i]
        }
    }
    pArr.forEach { _debug_println(it.joinToString(" ")) }

    val dp = sizedDoubleArray(X + 1, 0.0)
    for (i in 1..X) {
        var sum = 1.0
        for (j in 1..min(i, N)) {
            sum += dp[i - j] * pArr[N][j]
        }
        dp[i] = sum / (1 - pArr[N][0])
    }
    println("%.16f".format(dp[X]))
}
