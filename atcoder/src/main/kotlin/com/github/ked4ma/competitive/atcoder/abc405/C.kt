package com.github.ked4ma.competitive.atcoder.abc405

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.long.cumlative.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextLongList()
    val cumA = A.cumulativeSum()
    var ans = 0L
    for (i in range(N - 1)) {
        ans += A[i] * (cumA[N] - cumA[i + 1])
        _debug_println(ans)
    }
    println(ans)
}
