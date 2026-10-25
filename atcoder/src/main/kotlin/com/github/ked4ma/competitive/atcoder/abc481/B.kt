package com.github.ked4ma.competitive.atcoder.abc481

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextIntList()
    val A = nextIntList()
    var ans = 0
    if (A[0] == K) ans++
    for (i in 1 until N) {
        if ((A[i - 1] < K && A[i] >= K) || (A[i - 1] > K && A[i] <= K)) ans++
    }
    println(ans)
}
