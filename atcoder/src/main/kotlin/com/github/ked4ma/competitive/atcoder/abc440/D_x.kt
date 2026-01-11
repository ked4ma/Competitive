package com.github.ked4ma.competitive.atcoder.abc440

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.array.long.output.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.long.bound.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val A = nextLongList()
    val B = A.sorted()
    val ans = sizedLongArray(Q)
    repeat(Q) {
        val (X, Y) = nextLongList()
        val l = B.lowerBound(X)
        var ng = l - 1
        var ok = N
        while (ng + 1 < ok) {
            val m = (ok + ng) / 2
            if (B[m] - X + 1 - (m - l + 1) >= Y) {
                ok = m
            } else {
                ng = m
            }
        }
        ans[it] = X + Y - 1 + (ok - l)
    }
    ans.println("\n")
}
