package com.github.ked4ma.competitive.atcoder.abc454

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import kotlin.math.max
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private fun solve() {
    val (N, M) = nextIntList()
    var A = (nextLongList() + listOf(0)).toLongArray()
    for (i in N - 1 downTo 0) {
        A[i + 1] += M - A[i]
        A[i + 1] %= M
    }
    run {
        var l = 0
        var r = N
        while (l < r) {
            A[l] += A[r]
            A[l] %= M
            l++
            r--
        }
    }
    val n = N / 2 + 1
    A = A.sliceArray(0 until n)
    A.sort()
    var l = 0L
    var r = A.sumOf { M - it }
    var ans = LONG_INF
    for (i in 0 until n) {
        l += A[i]
        r -= M - A[i]
        ans = min(ans, max(l, r))
    }
    println(ans)
}
