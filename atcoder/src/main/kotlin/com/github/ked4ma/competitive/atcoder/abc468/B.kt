package com.github.ked4ma.competitive.atcoder.abc468

import com.github.ked4ma.competitive.common.array.boolean.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.max
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (M, D) = nextIntList()
    val S = nextCharArray()
    val arr = sizedBooleanArray(M)
    for (i in 0 until M) {
        if (S[i] == '.') continue
        for (j in max(0, i - D)..min(M - 1, i + D)) {
            arr[j] = true
        }
    }
    println(arr.count { !it })
}
