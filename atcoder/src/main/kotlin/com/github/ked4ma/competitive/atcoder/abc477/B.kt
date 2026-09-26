package com.github.ked4ma.competitive.atcoder.abc477

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.int.output.*
import kotlin.math.abs

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, D) = nextIntList()
    val X = nextIntList()
    val ans = mutableListOf<Int>()
    for (i in 0 until N) {
        var ok = true
        for (j in 0 until N) {
            if (i == j) continue
            if (abs(X[i] - X[j]) < D) {
                ok = false
                break
            }
        }
        if (ok) {
            ans.add(i + 1)
        }
    }
    println(ans.size)
    ans.println(" ")
}
