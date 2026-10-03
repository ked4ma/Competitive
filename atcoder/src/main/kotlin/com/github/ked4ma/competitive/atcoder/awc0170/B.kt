package com.github.ked4ma.competitive.atcoder.awc0170

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.div.ceil.*
import kotlin.math.abs

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextLongList().sorted()
    val s = A.sum()
    val x = s / N
    val y = (s % N).toInt()
    var ans = 0L
    for (i in 0 until N - y) {
        ans += abs(x - A[i])
    }
    for (i in N - y until N) {
        ans += abs(x + 1 - A[i])
    }
    ans = ans.ceilDiv(2)
    println(ans)
}
