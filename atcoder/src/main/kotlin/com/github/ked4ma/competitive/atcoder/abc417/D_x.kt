package com.github.ked4ma.competitive.atcoder.abc417

import com.github.ked4ma.competitive.common.array.int.d2.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.long.bound.*
import com.github.ked4ma.competitive.common.list.long.cumlative.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val M = 1024
    val inputs = times(N) {
        val (P, A, B) = nextIntList()
        Data(P, A, B)
    }
    val dp = sized2DIntArray(N + 1, M + 1, 0)
    for (i in 0 until M) {
        dp[N][i] = i
    }
    for (i in (0 until N).reversed()) {
        val (p, a, b) = inputs[i]
        for (j in 0..M) {
            dp[i][j] = if (j <= p) {
                dp[i + 1][j + a]
            } else {
                dp[i + 1][j - min(j, b)]
            }
        }
    }
    val cumB = inputs.map { it.b.toLong() }.cumulativeSum()
    _debug_println(cumB)

    fun access(x: Int): Int {
        if (x <= M) {
            return dp[0][x]
        }
        val downIndex = cumB.lowerBound(x.toLong() - M)
        if (downIndex == cumB.size) {
            return (x - cumB.last()).toInt()
        }
        return dp[downIndex][x - min(x, cumB[downIndex].toInt())]
    }

    val Q = nextInt()
    repeat(Q) {
        println(access(nextInt()))
    }
}

private data class Data(val p: Int, val a: Int, val b: Int)
