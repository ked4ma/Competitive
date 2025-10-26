package com.github.ked4ma.competitive.atcoder.abc429

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.combimation.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList()
    val cntMap = A.groupingBy { it }.eachCount()
    var ans = 0L
    for ((_, v) in cntMap) {
        if (v == 1) continue
        ans += combination(v.toLong(), 2) * (N - v)
    }
    println(ans)
}
