package com.github.ked4ma.competitive.atcoder.abc472

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import kotlin.math.abs
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val L = nextIntList()
    var l = 0
    var r = L.sum()
    var ans = INT_INF
    for (i in L.indices) {
        l += L[i]
        r -= L[i]
        ans = min(ans, abs(l - r))
    }
    println(ans)
}
