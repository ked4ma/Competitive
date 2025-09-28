package com.github.ked4ma.competitive.atcoder.abc425

import com.github.ked4ma.competitive.common.array.long.d2.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (T, M) = nextLongList().let { (T, M) -> T.toInt() to M }
    val comb = sized2DLongArray(5001, 5001, 0)
    comb[0][0] = 1
    for (i in 0 until 5000) {
        for (j in 0..i) {
            comb[i + 1][j] += comb[i][j]
            comb[i + 1][j] %= M
            comb[i + 1][j + 1] += comb[i][j]
            comb[i + 1][j + 1] %= M
        }
    }
    repeat(T) {
        solve(M, comb)
    }
}

private fun solve(mod: Long, comb: Array<LongArray>) {
    val N = nextInt()
    val C = nextIntList()
    var s = 0
    var ans = 1L
    for (c in C) {
        s += c
        ans *= comb[s][c]
        ans %= mod
    }
    println(ans)
}
