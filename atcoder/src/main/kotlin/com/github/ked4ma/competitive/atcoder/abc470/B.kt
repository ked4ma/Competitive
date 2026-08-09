package com.github.ked4ma.competitive.atcoder.abc470

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val C = nextIntList()

    val arr = sizedIntArray(N)
    for (c in C) {
        arr[c - 1]++
    }
    println(N - arr.max())
}
