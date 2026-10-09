package com.github.ked4ma.competitive.atcoder.awc0175

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextIntList() // K <= N
    val A = times(N) { nextLong() }
    val minA = A.min()
    _debug_println(A.sum())
    _debug_println(A.sum() / K)

    fun judge(m: Long): Boolean {
        var cnt = 1
        var x = 0L
        var i = 0
        while (i < N) {
            if (cnt > K) return false
            if (x + A[i] > m) {
                cnt++
                x = 0
                continue
            }
            x += A[i]
            i++
        }
        return cnt <= K
    }

    var ng = minA - 1
    var ok = LONG_INF
    while (ng + 1 < ok) {
        val m = (ng + ok) / 2
        if (judge(m)) {
            ok = m
        } else {
            ng = m
        }
    }
    println(ok)
}
