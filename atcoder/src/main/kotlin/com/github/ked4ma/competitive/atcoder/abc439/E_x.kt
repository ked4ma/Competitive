package com.github.ked4ma.competitive.atcoder.abc439

import com.github.ked4ma.competitive.common.array.int.bound.*
import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val AB = times(N) {
        val (A, B) = nextIntList()
        A to B
    }.sortedWith(compareBy({ it.first }, { -it.second }))

    val dp = sizedIntArray(N, INT_INF)
    for (i in 0 until N) {
        val j = dp.lowerBound(AB[i].second)
        dp[j] = AB[i].second
    }
    println(dp.lowerBound(INT_INF))
}
