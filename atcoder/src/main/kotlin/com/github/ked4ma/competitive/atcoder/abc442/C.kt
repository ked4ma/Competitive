package com.github.ked4ma.competitive.atcoder.abc442

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.array.long.output.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val G = sizedIntArray(N)
    repeat(M) {
        val (A, B) = nextIntList().map { it - 1 }
        G[A]++
        G[B]++
    }
    _debug_println(G)
    val ans = sizedLongArray(N)
    for (i in 0 until N) {
        val n = (N - G[i] - 1).toLong()
        ans[i] = if (n >= 3) {
            n * (n - 1) * (n - 2) / 6
        } else {
            0
        }
    }
    ans.println(" ")
}
