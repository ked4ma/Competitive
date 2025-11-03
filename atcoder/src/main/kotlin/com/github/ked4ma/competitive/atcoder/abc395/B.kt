package com.github.ked4ma.competitive.atcoder.abc395

import com.github.ked4ma.competitive.common.array.char.d2.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.range.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val arr = sized2DCharArray(N, N, '?')
    for (i in range(N)) {
        val j = N - 1 - i
        if (i > j) continue
        val c = if (i % 2 == 0) '#' else '.'
        for (k1 in i..j) {
            for (k2 in i..j) {
                arr[k1][k2] = c
            }
        }
    }
    println(arr.joinToString("\n") { it.concatToString() })
}
