package com.github.ked4ma.competitive.atcoder.abc434

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val sum = sizedIntArray(M, 0)
    val cnt = sizedIntArray(M, 0)
    for (i in 0 until N) {
        val (A, B) = nextIntList()
        sum[A - 1] += B
        cnt[A - 1]++
    }
    for (i in 0 until M) {
        println(sum[i].toDouble() / cnt[i])
    }
}
