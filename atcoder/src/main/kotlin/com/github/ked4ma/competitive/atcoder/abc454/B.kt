package com.github.ked4ma.competitive.atcoder.abc454

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.boolean.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val F = nextIntList()

    val arr = sizedIntArray(M)
    var ans1 = true
    var ans2 = 0
    for (f in F) {
        if (arr[f - 1] == 1) {
            ans1 = false
        }
        arr[f - 1]++
        if (arr[f - 1] == 1) {
            ans2++
        }
    }
    println(ans1.toYesNo())
    println((ans2 == M).toYesNo())
}
