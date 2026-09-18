package com.github.ked4ma.competitive.atcoder.awc0160

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextLongList().map { it - 1 }
    var ans = -LONG_INF
    var sum = 0L
    for (i in 0 until N) {
        sum += A[i]
        ans = max(ans, sum)
        if (sum < 0) sum = 0
    }
    println(ans)
}
