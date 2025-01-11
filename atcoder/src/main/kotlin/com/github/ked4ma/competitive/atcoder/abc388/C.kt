package com.github.ked4ma.competitive.atcoder.abc388

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList()
    var j = 0
    var ans = 0L
    for (i in range(N)) {
        while (j < N && A[i] * 2 > A[j]) j++
        ans += (N - j)
    }
    println(ans)
}
