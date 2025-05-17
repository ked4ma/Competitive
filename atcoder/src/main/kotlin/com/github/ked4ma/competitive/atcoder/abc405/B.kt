package com.github.ked4ma.competitive.atcoder.abc405

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val A = nextIntList()
    val cnt = sizedIntArray(101, 0)
    for (a in A) {
        cnt[a]++
    }
    var ans = 0
    while (ans < N && (1..M).all { cnt[it] > 0 }) {
        cnt[A[N - 1 - ans]]--
        ans++
    }
    println(ans)
}
