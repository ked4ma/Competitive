package com.github.ked4ma.competitive.atcoder.abc393

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.int.bound.*
import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val A = nextIntList()
    val qs = sizedArray(N) { mutableListOf<Pair<Int, Int>>() }
    repeat(Q) { i ->
        val (R, X) = nextIntList()
        qs[R - 1].add(i to X)
    }
    val ans = sizedIntArray(Q, 0)
    val dp = sizedIntArray(N, Int.MAX_VALUE)
    for (i in range(N)) {
        val index = dp.lowerBound(A[i])
        dp[index] = A[i]

        for ((j, x) in qs[i]) {
            ans[j] = dp.upperBound(x)
        }
    }
    println(ans.joinToString("\n"))
}
