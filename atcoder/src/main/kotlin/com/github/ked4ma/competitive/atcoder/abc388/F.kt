package com.github.ked4ma.competitive.atcoder.abc388

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M, A, B) = nextLongList()
    val LR = times(M.toInt()) {
        val (L, R) = nextLongList()
        L to R
    }
    var start = setOf(1L)
    for ((L, R) in LR) {
        if (L - 1 + B <= R) {
            println("No")
            return
        }
        val next = mutableSetOf<Long>()
        val l = L - (L - 1 + B - R)
        val r = L - 1
        val set = buildSet {
            for (s in start) {
                if (s > R) {
                    next.add(s)
                    continue
                }
                for (i in l..r) {
                    if (reachable(i - s, A, B)) add(i)
                }
            }
        }
        for (i in set) {
            for (j in A..B) {
                if (i + j in (R + 1)..N) {
                    next.add(i + j)
                }
            }
        }
        if (N in next) {
            println("Yes")
            return
        }
        start = next
    }
    println(if (start.any { i -> reachable(N - i, A, B) }) "Yes" else "No")
}

private fun reachable(x: Long, a: Long, b: Long): Boolean {
    if (x < 0) return false
    for (c in a..b) {
        val j = x / c
        if (x in j * c..j * b) return true
    }
    return false
}