package com.github.ked4ma.competitive.atcoder.abc450

import com.github.ked4ma.competitive.common.array.long.bound.*
import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.array.long.d2.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    var X = nextCharArray()
    val Y = nextCharArray()
    X = Y + X
    val Q = nextInt()
    val q = times(Q) {
        val (L, R, C) = nextList()
        Triple(L.toLong(), R.toLong(), C[0] - 'a')
    }

    val M = 1_000_000_000_000_000_000L

    val S = arrayOf(Y, X)

    val len = mutableListOf(Y.size.toLong(), X.size.toLong())
    val cnt = mutableListOf(
        sizedLongArray(26),
        sizedLongArray(26),
    )
    for (i in 0 until 2) {
        for (c in S[i]) cnt[i][c - 'a']++
    }
    val csum = sized2DLongArray(26, X.size + 1)
    for (i in 0 until X.size) csum[X[i] - 'a'][i + 1]++
    for (i in 0 until 26) {
        for (j in 0 until X.size) csum[i][j + 1] += csum[i][j]
    }

    while (len.last() < M) {
        val i = len.lastIndex
        len.add(len[i] + len[i - 1])
        cnt.add(cnt[i].copyOf())
        for (c in 0 until 26) cnt[i + 1][c] += cnt[i - 1][c]
    }

    fun f(i: Int, r: Long, c: Int): Long {
        if (i <= 1) return csum[c][r.toInt()]
        if (len[i - 1] < r) return cnt[i - 1][c] + f(i - 2, r - len[i - 1], c)
        return f(i - 1, r, c)
    }

    for ((l, r, c) in q) {
        _debug_println("${f(len.size, r, c)} ${f(len.size, l - 1, c)}")
        println(f(len.size, r, c) - f(len.size, l - 1, c))
    }
}
