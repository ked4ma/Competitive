package com.github.ked4ma.competitive.atcoder.abc393

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextIntList()
    val A = nextIntList()
    val M = 1000000

    val aCnt = sizedIntArray(M + 1, 0)
    for (a in A) {
        aCnt[a]++
    }

    val C = sizedIntArray(M + 1, 0)
    for (i in 1..M) {
        var sum = 0
        for (j in i..M step i) {
            sum += aCnt[j]
        }
        C[i] = sum
    }

    val ans = sizedIntArray(M + 1, 0)
    for (i in 1..M) {
        if (C[i] < K) continue
        for (j in i..M step i) {
            ans[j] = i
        }
    }

    println(A.map { ans[it] }.joinToString("\n"))
}