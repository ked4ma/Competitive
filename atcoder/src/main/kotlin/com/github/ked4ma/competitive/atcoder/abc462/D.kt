package com.github.ked4ma.competitive.atcoder.abc462

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, D) = nextIntList()
    val M = 1_000_005

    val arr = sizedIntArray(M)
    repeat(N) {
        var (s, t) = nextIntList()
        s--
        if (s + D <= t) {
            arr[s + D]++
            arr[t]--
        }
    }
    for (i in 1 until M) {
        arr[i] += arr[i - 1]
    }

    var ans = 0L
    for (i in 0 until M) {
        val n = arr[i].toLong()
        if (n >= 2) {
            ans += n * (n - 1) / 2
        }
    }
    println(ans)
}
